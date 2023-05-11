package com.user.delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dbcon.GetSQLConnection;


public class DeleteUser extends HttpServlet {
       

    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String email2 = null;
		
		try {
			ResultSet rs = GetSQLConnection.getStatement().executeQuery("select email from userdata;");
			while (rs.next()) {
				if (email.equals(rs.getString(1))) {
					email2 = email;
				}
			}

			if (email.equals(email2)) 
			{
				int x = GetSQLConnection.getStatement().executeUpdate("delete from userdata where email='" + email + "';");
				out.print("<h4 align=\"center\" style=\"color:red\">");
				out.print("Email " + email + " user deleted.");
				out.print("</h4>");

			} 
			else if (email.isEmpty()) 
			{
				out.print("<h4 align=\"center\" style=\"color:red\">");
				out.print("Enter Email for delete.");
				out.print("<h4>");
			} 
			else 
			{
				out.print("<h4 align=\"center\" style=\"color:red\">");
				out.print("User not Found");
				out.print("<h4>");
			}

//			RequestDispatcher rd = request.getRequestDispatcher("adminpage.html");
//			rd.include(request, response);
		} catch (Exception e) {
			out.print(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("pages/adminindex.html");
		rd.include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
