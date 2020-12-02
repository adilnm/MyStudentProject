package com.cuboc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewDetailsServlet")
public class ViewDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb", "root",
					"adil1986");
			PreparedStatement ps = con.prepareStatement("select * from universitydb.student ");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pw.println("Name: " + rs.getString(1) + " Id: " + rs.getString(2) + " Age: " + rs.getString(3));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
