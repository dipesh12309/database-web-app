package com.myapp.springdemo.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException{
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
			String usr="springstudent";
			String pwd="springstudent";
			String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.println("Connecting");
			Connection cn=DriverManager.getConnection(url, usr, pwd);
			out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
