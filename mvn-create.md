## Creating Maven project

1. Switch to c:\repos directory
   ```cmd
   $ cd \repos
   ```

2. Create new folder "mvn-project"
   ```cmd
   $ mkdir mvn-project
   $ cd mvn-project
   ```

3. Create FIRST maven project (interactive mode) You need to choose template (Just ENTER), groupId, artifactId and version
   ```cmd
   $ mvn    archetype:generate
   ```

4. Create SECOND maven project with Non Interactive mode
   ```cmd
   $ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart  
   -DartifactId=myapp1 -DgroupId=com.lti -DinteractiveMode=false -Dversion=1.0 
   -DarchetypeCatalog=internal
   ```

5. CREATE MAVEN PROJECT WITHOUT GENERATE COMMAND
   ```cmd
   #create the project folder
   $ cd \repos\mvn-project
   $ mkdir myapp2
   $ cd myapp2
   $ mkdir src\main\java
   $ mkdir src\main\resources
   $ mkdir src\test\java
   $ mkdir src\test\resources
   $ cd \repos\mvn-project\myapp2
   $ code .
   $ mvn compile
   ```












