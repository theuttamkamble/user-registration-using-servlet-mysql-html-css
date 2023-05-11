package com.user.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dbcon.GetSQLConnection;
import com.user.getmail.GetEmail;


public class VerifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VerifyUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String email2=null;
		
	
		try {
			ResultSet rs = GetSQLConnection.getStatement().executeQuery("select * from userdata where email='"+email+"';");

			out.print("<h1 align=\"center\">Your Details</h1>");
			out.print("<table border=\"1\" align=\"center\" cellspacing=\"0\" cellpadding=\"10\" style=\"border: 2px solid red; width:50%;background-color:azure;\"><tr>");
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
			
			
		} catch (Exception e) {
			out.print(e);
		}
		
		
		
		
		try {
			ResultSet rs = GetSQLConnection.getStatement().executeQuery("select email from userdata;");
			
			while(rs.next())
			{
				if(email.equals(rs.getString(1)))
				{
					email2=email;
					GetEmail.email=email;
				}
			}
		} catch (Exception e) {
			out.print(e);
		}
		
		
		out.print("<h4 align=\"center\" style=\"color:red\">");
		if(email.equals(email2))
		{
			//out.print("true");
			RequestDispatcher rd = request.getRequestDispatcher("pages/updateuser.html");
			rd.include(request, response);
		}
		else if(email.isEmpty())
		{
			out.print("Please Enter Email");
			out.print("</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("pages/adminindex.html");
			rd.include(request, response);
		}
		else
		{
			out.print("Enter valid email!");
			RequestDispatcher rd = request.getRequestDispatcher("pages/adminindex.html");
			rd.include(request, response);
		}
		out.print("</h3>");
		
		
	}

}
