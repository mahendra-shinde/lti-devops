## Maven project in jenkins

1. Login in Jenkins Dashboard (http://localhost:8082/jenkins)

2. Click "New Item" > Choose type "Free Style Project"
NOTE: FreeStyle project has NO DEPENDENCY on ANY PLUGIN

3. Project name: webapp1
Click "Save" button

4. Tab 1: General
	Add description

5. Tab 2:  Source Code Management
	Choose GIT
	Write repository path:
		https://github.com/mahendra-shinde/ci-servlet-demo

6. Tab 3: Build Triggers
	Choose Poll SCM : H/5 * * * *
	NOTE:  Check if any CHANGES (Commit) happended in every 5 		minutes.

7. Tab 4: Build Enviornment
	Choose "Delete workspace before build"

8. Tab 5: Build
	Maven version: M3
	Goal: package

9. Tab 6: Post Build
	Choose "Deploy war/ear to container"
	WAR/EAR files:	target/**.war
	Containers:
		Credentials: Click add 
			[username: manager, password: pass1234]
		URl:  http://192.168.100.86:8082/manager	

        Replace 192.168.100.86 with localhost to deploy on local tomcat