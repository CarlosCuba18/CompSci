#  MD Assignment Workflow Cheat-sheet

## To Start an Assignment:

  ```bash
  open {web-url}       
  # obtain the {git-url}
  cd ~/classes/comp122/deliverables
  git clone clone {git-url}
  cd ~/classes/comp122/deliverables/{assignment}-{account}
  cp assignment.md submission.md
  git add submission.md
  subl submission.md
  git commit -m '{comment}'
  git pull ; git push
  ```

## Incrementally Work on an Assignment 

  ```bash
  git switch main              # Optional
  for(( ; ; )) ; do 
    subl submission.md
    make response_key
    git commit -m '{comment}' submission.md
    make validate
    git pull ; git push
  done
  ```

## To Finish Assignment

  ```bash
  git tag submitted
  git push origin submitted
  make confirm
  ```

## To Obtain your Grade Report

  After the Professor announces, via slack, that grades are available.
  ```bash
  git pull
  cat grade.report
  ```

# [Git Command List Cheat-sheet](git_cheatsheet.md)
