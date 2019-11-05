## Maven build properties

Allows Operations (Deployment eng) to set certain properties like Db Connection strings
from maven command or from jenkins project.

## Level 1:
1. Create a new file under `src/main/resources` folder with name `db.properties`

    ```ini
    url=jdbc:oracle:thin:@localhost:1521/xe
    username=hr
    password=hr
    ```
2.  Modify / create `com.lti.servlets.DBUtil` class:

    ```java
    package com.lti.servlets;

    import java.sql.*;
    import java.util.Properties;

    public class DBUtil {
        //Collection of properties
        
        private static  String url ;
        private static  String user; 
        private static  String pass;
        
        // Try to get value from db.properties if not found then use default values
        /// dbProps.getProperty("key","defaultValue");
        //  returns "defaultValue" when "key" is NULL
        static { 
            Properties dbProps = new Properties();
            try {
            dbProps.load(DBUtil.class.getResourceAsStream("/db.properties"));
            url = dbProps.getProperty("url");
            user = dbProps.getProperty("username");
            pass = dbProps.getProperty("password");
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public static Connection getConnection() 
            throws SQLException, ClassNotFoundException
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url,user,pass);
        }
        
        
        public static void close(Connection con) {
            try {
                con.close();
            }catch(Exception ex) {
                System.out.println("Unable to close connection, may be its not OPEN !");
                ex.printStackTrace();
            }
        }
    }
    ```

3.  Create a new Servlet named 'HomeServlet' with URL pattern "/test"

    ```java
    @WebServlet("/test")
    public class HomeServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        
        public HomeServlet() {
            super();

        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            
            PrintWriter out = response.getWriter();
            response.setContentType("text/plain");
            out.println("Testing DB Connectivity ");
            try {
            Connection con = DBUtil.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from TAB");
            int i =1;
            while(rs.next()) {
                out.println(i+" "+rs.getString("TNAME"));
                i++;
            }
            //Try inserting a new records
            PreparedStatement ps = con.prepareStatement("INSERT into REGIONS values(?,?)");
            ps.setInt(1,5);
            ps.setString(2, "Antarctica");
            ps.executeUpdate();
            DBUtil.close(con);
            
            }catch(SQLException | ClassNotFoundException ex) {
                ex.printStackTrace(out);
            }
            
            out.close();
            
        }
        
    }
    ```
4.  Use project > Team > Commit

    Add all files and provide some message then click "Commit"

5.  Launch your JENKINS instance and open browser at http://localhost:8082/jenkins

6.  Create new FreeStyle project

    - Tab 1
        Description : project with maven properties
    
    - Tab 2
        Choose Version control : Git
        Git Repository:  c:\repos\lti-devops
    
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
