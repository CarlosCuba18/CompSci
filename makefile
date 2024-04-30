# Makefile for COMP122 Markdown (MD) assignments
#   Validates compliance with a minimal set of requirements.
#   Generates the students 'response key' for student viewing
#
# The global tag ($SUBMISSION_TAG) MUST be associated with the version of $SUBMISSION you want graded
#
# Minimum Requirements for Grading
#   1. There is a $SUBMISSION file
#   1. The string "{name}" has been replaced with the student's name
#   1. The string "{account}" has been replace with the student's github account
#   1. A minimal number of commits have been made to the $SUBMISSION file
#   1. A tag ($SUBMISSION_TAG) has been established
#   1. The tag has been pushed to the origin
#   1. The commit date of the global tag must be on or BEFORE the DUE_DATE

BRANCH=main
MIN_COMMITS=6

#########################################################################################----
# Variable Definitions associated with SUBMISSION

SUBMISSION=submission.md
SUBMISSION_TAG=submitted

NAME=$(shell awk '/Name:/ {print $$3}' ${SUBMISSION} )
ACCOUNT=$(shell awk '/GitHub Account:/ {print $$4}' ${SUBMISSION} )
NUM_COMMITS=$(shell git rev-list --count origin/${BRANCH} -- ${SUBMISSION} )
HAS_TAG=git show-ref --quiet --tags 
DUE_DATE ?= $(shell cat DUE_DATE)


#########################################################################################----
# Variable Definitions associated with Makefile processing
SHELL=/bin/bash
TO_GRADE ?= 
MAKEFILE ?= makefile


#########################################################################################----
# Make Targets explained
# 
# all: (the first target)
#   - the standard default target
#   - provides a menu to inform the student on top-level targets
#
# response_key:
#   - produces the student's response_key 
#   - no steps are performed to validate the structure of the repo
#
# validate: 
#   - checks the administrative requirements of the assignment
#   - used by the github to run a validation check of a student submission
#   - invoked by github via `make -k validate`
#
# confirm:
#   - validates the administrative requirements are meet
#   - presents the response key as is tagged
#
# pregrade:
#   - used by the Prof to validate the submission prior to grading
#
# grade: 
#   - the target used by the Prof to support auto-grading

all:
	@echo 
	@echo "To review your response:"
	@echo "  \"make response_key\" "
	@echo "  \"open ${SUBMISSION}\" "
	@echo "  \"subl ${SUBMISSION}\" "
	@echo ""
	@echo "Recall that your submission must be properly presented for all three formats"
	@echo
	@echo "To validate the structure of your submission:"
	@echo "  \"make validate\" "
	@echo 
	@echo "To confirm your assignment as been correctly submitted:"
	@echo "  \"make confirm\" "
	@echo


response_key: ${SUBMISSION} 
	@echo ---------------------------------
	@echo Press \"RETURN\" to review your responses:
	@echo 
	@read
	@echo ================================================================================
	@bin/create_response_key < ${SUBMISSION}
	@echo ================================================================================
	@echo
	@ git diff --quiet ${SUBMISSION_TAG} -- ${SUBMISSION} 2>/dev/null || \
	  { echo "Notice: Current version has not been submitted!" ; \
	    echo "        Hint: commit, tag, push"; }
	@echo


validate: validate_submission_file validate_name validate_account number_commits due_date


confirm: validate
	@-git switch --detach ${SUBMISSION_TAG}
	@-make -f ${MAKEFILE} response_key
	@-git switch main        



validate_submission_file:
	@[[ -f ${SUBMISSION} ]] || \
	  { echo "Missing file: \"${SUBMISSION}\"" ; false ; }

validate_name:
	@[[ -n "${NAME}" ]] && [[ "${NAME}" != "{name}" ]]

validate_account:
	@[[ -n "${ACCOUNT}" ]] && [[ "${ACCOUNT}" != "{account}" ]]

number_commits:
	@[[ ${NUM_COMMITS} -ge ${MIN_COMMITS} ]]  ||  \
	  { echo "Pushed Commits:  ${NUM_COMMITS} < ${MIN_COMMITS} required commits" ; false ; }

due_date: tagged matched_tags DUE_DATE
	@bin/git_tagged_ontime "${DUE_DATE}" ${SUBMISSION_TAG} || \
	  { echo "Due date violation: Due Date: ${DUE_DATE} ; tag=${SUBMISSION_TAG}";  false ; }

tagged:
	@${HAS_TAG} ${SUBMISSION_TAG} || \
	  { echo "Missing tag: ${SUBMISSION_TAG}" ; false ; }

matched_tags: 
	@bin/git_matched_tags ${SUBMISSION_TAG} || \
	  { echo "Remote/Local Tag Mismatch:  ${SUBMISSION_TAG} (hint 'git push origin submitted')" ; false ; }



#########################################################################################----
# Grading Based Make Targets
#
# The Professor will ONLY grade your assignment if it meets the 
# minimum requirements for grading -- see above.
#   
# The Professor may consider grading material submitted after the DUE_DATE, 
# IFF prior arrangements are made (see exceptions in the Syllabus)

pregrade: validate
	@create_response_key < ${SUBMISSION} > response_key.md

# Notice the Profess is reviewing three things in the grading of your submission
#   1. how it renders as a MD file
#   1. how it is presented within the subl editor
#   1. how well craft your answers as presented in the response key
grade: 
	@open ${SUBMISSION}  
	@subl ${SUBMISSION} 
	@subl response_key.md

