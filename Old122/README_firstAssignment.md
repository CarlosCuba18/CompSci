
# Additional Instructions for the First Assignment

Students within Computer Science and Computer Information Technology programs are better served if they learn and utilize source control systems early in their academic program. Learning various markdown languages, which are used to document their software projects, is also advantages.

While using a Canvas might be a easier for you to submit assignments, using canvas provides you with little long-term benefit.  

As such, we will be using GitHub Classrooms for all of our paper-like assignments, which includes quizzes and exams in COMP122. Additional, a semi-automatic grading process is also used as part of this process. This should result in a faster turn-around in grading.

To submit your assignments and for the Professor to grade them efficiently, there are a number of steps that you must follow. This assignment is being provided to you to ensure you understand these steps and to allow you to address any issues that may prevent you from submitting your assignments.

In class, the professor will review each of these steps and provide additional information as to what these commands do. For now, simply follow the instructions.

## First-Time GitHub Users
  1. Obtain a github account (https://github.com).
     - In this document, this account is referenced as "{account}"
     - As such, you need to replace this string with your github account name in all subsequent commands
  1. Launch a terminal
  1. Run the following command `comp122-keygen`.  When prompted to enter a passphrase, simply hit enter.  Your output should be similar to the following:
     ```
     $ comp122-keygen
     Generating public/private ed25519 key pair.
     Enter passphrase (empty for no passphrase): 
     Enter same passphrase again: 
     Your identification has been saved in /Users/steve/.ssh/id_comp122_github
     Your public key has been saved in /Users/steve/.ssh/id_comp122_github.pub
     The key fingerprint is:
     SHA256:N3zkoMQGrthZVIYJd/PqCgPrnE5vrztNOpOVhgHEq+Q comp122 git@github.com
     The key's randomart image is:
     +--[ED25519 256]--+
     | o. ..++=        |
     |  o  +o= o       |
     |   o  o + o .    |
     | ..o.+ o + +     |
     |o.o +o .S + o    |
     |.E o. =. . o     |
     |  o oB  .        |
     | + oBo..         |
     | .=.+Bo          |
     +----[SHA256]-----+
     
     A copy of your public key has been placed into the clip board.
     
     Add this key to your github account."
    
     1. Execute the following command:
       ${LAUNCH} https://github.com/settings/ssh/new
     2. Fill in the form
        a. For 'Title': enter a name for this key, e.g., COMP122
        b. For 'Key type': select 'Authentication Key'
        c. For 'Key': paste your key
     3. Click on the 'Add SSH Key' button
   

     Copy this public key to your github account!
     To add it to your github account, execute the following command:
     
       open https://github.com/settings/keys
     
     $
     ```
  1. Run either `open` or `start` command with the URL: https://github.com/settings/keys

  1. Click on the green button labeled "New SSH Key"
     1. Enter a title for your new key, e.g., "My SSH Key for COMP122"
     1. Ensure the Key Type is set to: Authentication Key
     1. Click in the Key box.
     1. Paste your public-key (Ctl-V, Command-V, etc.)
     1. Click on "Add SSH Key"
 
  1. Test your SSH
     1. In the terminal window type the command: `ssh -T git@github.com`. Your output should be similar to the following:
        ```
        $ ssh -T git@github.com
        Hi {account}! You've successfully authenticated, but GitHub does not provide shell access.
        $
        ```
 
   1. For more information see: [GithHub and SSH Authentication](https://docs.github.com/en/authentication/connecting-to-github-with-ssh).


## Joining the comp122-f24 Classroom
  1. Click on the following assignment link: https://classroom.github.com/a/5mXbyUv_
  1. Join the comp122-f24 classroom.
     - if your email address is not listed, STOP and notify the Professor.
  1. Accept the assignment.
  1. Wait a bit and then refresh the page.


## Accept the Assignment
  1. Launch a terminal
  1. Go to your deliverables directory
     ```
     cd ~/classes/comp122/deliverables
     ```
  1. Use the Assignment's Invitation URL to accept the assignment.
     - For this assignment, the URL is: https://classroom.github.com/a/5mXbyUv_
     - All Invitations URL are recorded in the "assignments.md" file.

  1. Click on the URL that is associated with your assignment repository. The URL should be of the form: <br />  https://github.com/COMP122/02-first-MD-assignment-{account}


  1. Obtain the git URL for this assignment: <br/>
     - Click on the green "Code" button.
     - Select "SSH" menu tab.
     - Copy the ssh-style URL.
     This URL should look like: `git@github.com:COMP122/02-first-MD-assignment-{account}`

  1. Clone this repository to your computer, e.g., 
     ```
     git clone git@github.com:COMP122/02-first-MD-assignment-{account}.git
     ```
     Remember that you need to replace the substring "{account}" with your GitHub account name. (See the URL you obtained from the previous step.)

You may now go back to the [README.md](READDME.md).  Pickup on Step 3 in the 'To Get Started' Section.

