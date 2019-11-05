## Prepare local tomcat to accept deployments from jenkins

1.  Goto your tomcat's `conf` folder and replace existing `tomcat-users.xml` with [this](./tomcat-users.xml) file

2.  Launch tomcat and access URL:
        http://localhost:8082/manager

3.  Enter credentials:

    ```yaml
    username: manager
    password: pass1234
    ```

4.  For deployment on REMOTE tomcat (ie. tomcat running on different machine, your need `context.xml` file)

    Copy [this](./context.xml) into `webapps/manager/META-INF` folder
