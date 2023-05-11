package com.user.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dbcon.GetSQLConnection;


public class DisplayUser extends HttpServlet {
       

    public DisplayUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			ResultSet rs = GetSQLConnection.getStatement().executeQuery("select * from userdata;");
			
			out.print("<h1 align=\"center\">Users List</h1>");
			out.print("<table border=\"1\" align=\"center\" cellspacing=\"0\" cellpadding=\"10\" style=\"border: 2px solid red; width:80%;background-color:azure;\"><tr>");
			out.print("<tr><td><b>Name:</b></td> <td><b>Mobile:</b></td> <td><b>Email:</b></td> <td><b>City:</b></td><td><b>Password:</b></td></tr>");
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+rs.getString(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getString(5)+"</td>");
				out.print("</tr>");
				
			}
			//out.print("<td><a href=\"adminpage.html\">Form</a></td>");
			out.print("</tr></table><br>");
			RequestDispatcher rd = request.getRequestDispatcher("pages/adminindex.html");
			rd.include(request, response);
		} catch (Exception e) {
			out.print(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("pages/adminindex.html");
			rd.include(request, response);
		}
	}

}
