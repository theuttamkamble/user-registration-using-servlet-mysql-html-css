package com.user.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dbcon.GetSQLConnection;
import com.user.getmail.GetEmail;


public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String compemail=GetEmail.email;
		
		
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String password = request.getParameter("pass");
		
		
		String nameq = "";
		String mobileq = "";
		String emailq = "";
		String cityq = "";
		String passwordq = "";
		
		
		out.print("<h4 align=\"center\" style=\"color:red\">");
		
		if(name.isEmpty()==false)
		{
			nameq="name='"+name;
//			out.print("update userdata set "+nameq+"' where email='"+compemail+"';");
//			out.print("<br>");
			
			try {
				int res = GetSQLConnection.getStatement().executeUpdate("update userdata set "+nameq+"' where email='"+compemail+"';");
				//out.print("User updated");
			} catch (Exception e) {
				out.print(e.getMessage());
			}
			
			
		}
		
		if(mobile.isEmpty()==false)
		{
			mobileq="mob="+mobile;
//			out.print("update userdata set "+mobq+" where email='"+compemail+"';");
//			out.print("<br>");
			
			try {
				int res = GetSQLConnection.getStatement().executeUpdate("update userdata set "+mobileq+" where email='"+compemail+"';");
				//out.print("User updated");
			} catch (Exception e) {
				out.print(e.getMessage());
			}
		}
		
		
		
		if(city.isEmpty()==false)
		{
			cityq="city='"+city;
//			out.print("update userdata set "+cityq+"' where email='"+compemail+"';");
//			out.print("<br>");
			
			try {
				int res = GetSQLConnection.getStatement().executeUpdate("update userdata set "+cityq+"' where email='"+compemail+"';");
				//out.print("User updated");
			} catch (Exception e) {
				out.print(e.getMessage());
			}
		}
		
		if(password.isEmpty() == false)
		{
			passwordq="pass='"+password;
//			out.print("update userdata set "+passq+"' where email='"+compemail+"';");
//			out.print("<br>");
			
			try {
				int res = GetSQLConnection.getStatement().executeUpdate("update userdata set "+passwordq+"' where email='"+compemail+"';");
				//out.print("User updated");
			} catch (Exception e) {
				out.print(e.getMessage());
			}
		}
		
		if(email.isEmpty()==false)
		{
			emailq="email='"+email;
//			out.print("update userdata set "+emailq+"' where email='"+compemail+"';");
//			out.print("<br>");
			
			try {
				int res = GetSQLConnection.getStatement().executeUpdate("update userdata set "+emailq+"' where email='"+compemail+"';");
				//out.print("User updated");
			} catch (Exception e) {
				out.print(e.getMessage());
			}
		}
		out.print("User updated");
		
		if(name.isEmpty() && mobile.isEmpty() && email.isEmpty() && city.isEmpty() && password.isEmpty() == true)
		{
			out.print("Insert data");
		}
		out.print("</h3>");
		
		
		
		
		try {
			ResultSet rs = GetSQLConnection.getStatement().executeQuery("select * from userdata where email='"+GetEmail.email+"';");

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
		

		RequestDispatcher rd = request.getRequestDispatcher("pages/updateuser.html");
		rd.include(request, response);
		
		
	}

}
