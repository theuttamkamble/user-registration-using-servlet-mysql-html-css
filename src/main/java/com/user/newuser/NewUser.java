package com.user.newuser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dbcon.GetSQLConnection;


public class NewUser extends HttpServlet {

    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String mob = request.getParameter("mobile");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String pass1 = request.getParameter("password");
		String pass2 = request.getParameter("confirmpassword");
		
		try {
			if(pass1.equals(pass2)) {
				
				int i = GetSQLConnection.getStatement().executeUpdate("insert into userdata values ('"+name+"', "+mob+", '"+email+"', '"+city+"', '"+pass1+"' );");
				out.print("<h4 align=\"center\" style=\"color:red\">");
				out.print(i+" user created.");
				out.print("</h4>");
				RequestDispatcher rd=request.getRequestDispatcher("pages/adminindex.html");
				rd.include(request, response);
				
			}
			else 
			{
				
				out.print("<h4 align=\"center\" style=\"color:red\">");
				out.print("No password match!");
				out.print("</h4>");
				RequestDispatcher rd=request.getRequestDispatcher("pages/adminindex.html");
				rd.include(request, response);
				
			}
			
			
			
		} catch (Exception e) {
			
			out.print("<h4 align=\"center\" style=\"color:red\">");
			out.print(e.getMessage());
			out.print("Please fill the form");
			out.print("</h4>");
			RequestDispatcher rd=request.getRequestDispatcher("adminindex.html");
			rd.include(request, response);
		}
	}

}
