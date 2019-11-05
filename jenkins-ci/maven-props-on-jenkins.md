1. Clone my repository in local machine

    ```cmd
    $ cd \repos
    $ git clone https://github.com/mahendra-shinde/lti-devops
    $ cd lti-devops
    ```

2.  Launch your JENKINS instance and open browser at http://localhost:8082/jenkins

6.  Create new FreeStyle project

    - Tab 1
        Description : project with maven properties
    
    - Tab 2
        Choose Version control : Git
        Git Repository:  c:\repos\lti-devops (Refer to step# 1)
    
    - Tab 3
        Build Trigger: Poll SCM
        Scheule:    H/5 * * * *
    
    - Tab 4
        Build Environment
        Check: Delete workspace before build starts
    
    - Tab 5
        Choose: Invoke Top Level Maven targets
        Maven Version: M3
        Goals: package
        Click "Advance" button
        POM:    jdbc-demo\pom.xml
        Properties:
            dburl=jdbc:oracle:thin:@192.168.100.86:1521/xe
            user=hr
            pass=hr
        
    - Tab 6
        Choose "Deploy war/ear to container"
	    WAR/EAR files:	jdbc-demo/target/**.war
	    Containers:
		    Credentials:	[username: manager, password: pass1234]
		URl:  http://localhost:8082/manager	
