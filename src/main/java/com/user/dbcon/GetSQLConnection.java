package com.user.dbcon;
import java.sql.*;


public class GetSQLConnection {	
	public static Statement getStatement() throws ClassNotFoundException, SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydata";
		String uname="root";
		String pass="root";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, uname, pass);
		Statement stm = conn.createStatement();
		return stm;
		
	}
	
}
