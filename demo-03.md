## Git Local/Remote Sync

1.  SignUp or Login on https://github.com

2.  Click on `New Repository` on right-top corner.

3.  Enter repository name `lti-devops`, choose type `Public` and add `ReadMe` file.

4.  Click on `Create` button

5.  Start `Git Bash` and clone the remote repository

    ```bash
    $ cd /c/repos/
    ## PLEASE REPLACE {YOURACCOUNT} with your github account 
    ## Remove Curly Braces!!
    $ git clone https://github.com/{YOURACCOUNT}/lti-devops
    $ cd lti-devops
    $ git status
    ```

6.  Add few files and commit + Push to remote

    ```bash
    $ git config --global user.email "{YOUR GITHUB EMAIL}"
    $ notepad file1.txt
    $ git status
    $ git add .
    $ git commit -m "Added a file"
    $ git push
    ```

    > NOTE: REPLACE `{YOUR GITHUB EMAIL}` with Email you used for signup on GitHub.com