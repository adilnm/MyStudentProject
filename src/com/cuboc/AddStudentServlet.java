package com.cuboc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdName=request.getParameter("stdName");
		int stdid=Integer.parseInt(request.getParameter("stdid"));
		int stdAge=Integer.parseInt(request.getParameter("stdAge"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","root","adil1986");
			PreparedStatement ps=con.prepareStatement("insert into universitydb.student values(?,?,?)");
			ps.setString(1, stdName);
			ps.setInt(2, stdid);
			ps.setInt(3, stdAge);
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
