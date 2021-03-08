package com.test.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJDBC
 */
@WebServlet("/TestJDBC")
public class TestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String jdbcUrl ="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		 String user = "springstudent";
		 String pass = "springstudent";
		 
		 String driver = "com.mysql.cj.jdbc.Driver";
		 try {
			 PrintWriter out = response.getWriter();
			 out.println("Connecting to Database at URL : jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC");
			 
			 Class.forName(driver);
			 Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			 
			 out.println("Connected Successfully");
			 


			 
		 }
		 catch(Exception exc){
			
			 exc.printStackTrace();
			 
			 throw new ServletException(exc);
		 }
	}

}
