## Prepare local tomcat to accept deployments from jenkins

1.  Goto your tomcat's `conf` folder and replace existing `tomcat-users.xml` with [this](./tomcat-users.xml) file

    - When you open [file](./tomcat-users.xml) please click "Raw" button to open in in RAW format and then press CTRL + S to save it on your disk.

2.  Launch tomcat and access URL:
        http://localhost:8082/manager

3.  Enter credentials:

    ```yaml
    username: manager
    password: pass1234
    ```

4.  For deployment on REMOTE tomcat (ie. tomcat running on different machine, your need `context.xml` file)

    Copy [this](./context.xml) into `webapps/manager/META-INF` folder

    > Please NOTE tomcat manager only accept request on "localhost" the above step allows it to be accessed using IP address.