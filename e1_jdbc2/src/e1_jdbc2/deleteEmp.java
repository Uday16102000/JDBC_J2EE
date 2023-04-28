package e1_jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteEmp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
		
		//1.load or register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establish connection
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		//3.Create statement
		Statement statement= connection.createStatement();
		
		//4.execute statement
		int a=statement.executeUpdate("delete from employee where id=2");
		System.out.println(a);
		
		//5.close
		connection.close();
	}
	
	
}
