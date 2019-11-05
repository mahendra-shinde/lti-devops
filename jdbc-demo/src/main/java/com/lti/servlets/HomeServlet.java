package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
