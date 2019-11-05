## Installing Jenkins

1. Copy "jenkins.war" from `SharedFolder`

   > You also can Download it from https://jenkins.io/download Use last option "Generic WAR Package"

2.  Locate your apache tomcat (Version 7 onwards), and copy this war file into "webapps" SharedFolder

3.  Launch tomcat using "bin\startup.bat"

    > Not able to launch using startup.bat try this:
    - Open command prompt in tomcat\bin folder and try following commands:
        $ set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_201
        $ startup.bat

4.  Open your web-browser and write address:
        - http://localhost:8080/jenkins  (Default)
        - http://localhost:8082/jenkins  (When 8080 is used by Other process)

5.  Now, browser page should ask for password and also should display file which contains password

    - Open command prompt and use following command to read password:
        $ type {FILE PATH}

    - The {FILE PATH} should be C:\users\USERNAME\.jenkins\secrets\initialAdminPassword

6.  On Next Screen, click "Install Recommanded Plugins" and wait for plugin installation to end.

7.  Click on "Continue" button and provide new user details to create a new admin user.

8.  Click on "Continue" button to launcg Jenkins Dashboard.

9.  Click on "Manage Jenkins" > "Manage Plugins"


10. Click on "Available" TAB and search for "deploy to container" using filter text field.

11. Check the "deploy to container" and click "Install without restart"

