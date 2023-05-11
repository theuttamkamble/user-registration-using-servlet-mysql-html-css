package com.user.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLogin extends HttpServlet {

    public AdminLogin() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("adminname");
		String pass = request.getParameter("adminpassword");
		
		if(name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("pages/adminindex.html");
			rd.include(request, response);
		}
		else
		{
			out.print("<h3 align=\"center\" style=\" color: red \">");
			out.print("Incorrect Admin ID or Password!");
			out.print("</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
