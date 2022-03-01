package practiceproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dashboard {
	
	public static final String URL="jdbc:mysql://localhost:3306/players";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Deepika@123";
	PreparedStatement prep;
	ResultSet theResultSet;
	Connection conn;
	Dashboard(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("driver not registered");
		} catch (SQLException e) {
			System.out.println("please connect");
		}
	}

	
}
