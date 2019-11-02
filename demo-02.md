## Git basic demo1

1. Goto your C: Drive and create new folder `repos` 
    (Using File explorer or command prompt)

2.  Launch `Git Bash` and switch to newly created folder

    $ cd /c/repos/


3.  Create an EMPTY repository with name `project1`

    $ git init project1

    NOTE: The `init` command creates a new working directory `project` 
          with empty repository `project1/git` (also empty INDEX !!)

4.  Try creating a new file using notepad

    $ notepad Hello.java
    or
    $ /c/windows/system32/notepad.exe Hello.java

5.  After writing some valid java code, save the changes and add files to staging area.

    $ git add Hello.java
    $ git status

6.  Now, Commit the changes to local repository.

    $ git commit -m "First Commit"

7.  Add one more file `Greet.java` and commit init

    $ notepad Greet.java
    $ git add .
    $ git commit -m "new file"

8.  Try to switch between commits (Time travel!!)

    $ git log
    ## Note down the both COMMIT IDs
    ## AND SWITCH TO FIRST COMMIT (9723)
    $ git checkout 9723
    $ dir
    ## So, Greet.java simply disappeared!
    ## Switch back to second commit
    $ git checkout 374a 
    $ dir
    ### Switch to latest commit
    $ git checkout master

9.  Git DIFF (Compare TWO commits at a time)

    $ notepad Greet.java
    ## One a new line and save the changes
    $ git add .
    $ git commit -m "changes the message"
    # View history and note down the last TWO commit IDs
    $ git log
    ### 374a was OLD and b075 was NEW commit id
    $ git diff 374a b075


10. Branching : create a new branch and switch

    $ git status
    $ git branch
    ## create NEW branch from MASTER
    $ git checkout -b dev1
    ## Switch back to MASTER
    $ git checkout master
    ## create NEW branch from MASTER
    $ git checkout -b dev2
    ## LIST all branches
    $ git branch

11. Add code in dev1 branch

    $ git checkout dev1
    $ notepad Main.java
    $ git add .
    $ git commit -m "Main method"
    $ git log
    $ git checkout master
    $ git log
