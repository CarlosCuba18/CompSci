# General Assignment Directions
These are the general directions to all assignments that require the student to submit a document.  Such documents shall be in the MD (markdown) format, and MUST be named "submission.md".


## Additional Instructions for the First Assignment

If this is the first assignment, refer to [README_firstAssignment.md](README_firstAssignment.md) for additional instructions.

## To Get Started on this Assignment
  1. Accept this assignment via the link provided by the Professor.
     * Obtain the URL for your repository: {git-url}

  1. Clone this repository to your computer within the deliverables subdirectory. 
     ```
     cd ~/classes/comp122/deliverables
     ls
     git clone {git-url}
     ls
     ```

  1. Review the "assignment.md" file.
     ```
     cd ~/classes/comp122/deliverables/{assignment}-{account}
     cat assignment.md
     ```

  1. Make a copy of this file, naming it "submission.md": 
     `cp assignment.md submission.md`

  1. Edit this file: `subl submission.md`:
     * to include your name in the appropriate location
     * to include your github account in the appropriate location

  1. Add this file to your local repository: 
     `git add submission.md`

  1. Commit this file to your local repository with a message: 
     `git commit -m '{coment}'`

  1. Run the command `make response_key`, to see your responses so far.

  1. Run the make command to obtain a menu of options.

  1. Run the command `make validate`, to validate your work.

     At this point, it is okay if you have errors. As you work on the assignment, you will need to take steps to address the errors within your submission.  If you get no output, then all errors have been addressed!


  1. Run the following commands to synchronize the remote and local repositories.
     * `git pull` :  Incorporate any updates from the remote.
     * `git push` :  Publish the contents of your local repository.

     The Professor can only grade information that exists in the remote repository.

## Work on the Assignment
  1. Incrementally edit, commit, and upload your "submission.md" file.
     ```
     subl submission.md
     make response_key
     git add submission.md
     git commit -m '{message}' submission.md
     git pull ; git push
     ```

     - Get into the habit of reviewing your work.
     - Get into the habit of making incremental updates to your working assignments.
     - Get into the habit to publish your work periodically.


  2. Provide a response to all items that are identified with: `<!-- response -->`
     - This string is just an HTML comment that does not render in the final document.
     - These comments are also used to create your final answer key which is used for grading.
     - Your answer *must* be placed it to the left of the HTML comment.
     - If you add additional answers, you *must* place a HTML comment to the right of that answer.
     - You *must* remove any response comments that you don't need.

  3. Use additional spacing to ensure your answer is _easy_ to read to maximize credit.

  4. Add additional information as you feel is necessary to maximize credit.

  5. Remember to review the presentation of your submission in all three required formats:
     1. `make response_key`  : to be reviewed for grading your answers
     1. `subl submission.md` : to be reviewed by other programmers
     1. `open submission.md` : to be reviewed by users, managers, others, etc


## Complete and Submit the Assignment

  1. Tag your assignment with the submission tag and publish said tag: submitted
     ```
     git tag submitted
     git push origin submitted
     ```

  1. Run `make confirm` one more time to validate your response key.

  1. If the response key is not correct
       - go back to the `Work on the Assignment` section
       - and then re-tag your assignment
         ```
         git tag --delete submitted
         git tag submitted
         ```
      - and then republish the tag
        ```
        git push origin :submitted    # to unpublish the tag
        git push origin submitted     # to publish the tag
        ```

## Grading
   1. A semi-automated process will be used to expedite the grading of this assignment. 
   2. As such, it is important that you position your answers appropriately within the file called "submission.md"
   3. As part of the grading process, the Professor may add two files to your repository:
      1. "answers.md": which provides the Professor's solution to the assignment.
      1. "grade.report": which provides your final score and associated breakdown.
   4. The professor will announce via slack when a particular assignment has been graded.

## Minimum Requirements for Grading
   1. The file submission.md exists, this is the only file the Prof will grade.
   1. The string "{name}" has been replaced with the student's name.
   1. The string "{account}" has been replace with the student's github account.
   1. A minimal number of commits have been made to the submission.md file
   1. The tag, submitted, has been established.
   1. The tag has been pushed to the origin.
   1. The commit date of the published tag must be on or BEFORE the DUE_DATE




