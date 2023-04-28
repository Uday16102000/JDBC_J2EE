package e1_jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class retrieveEmp 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 //1.load or register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establish connection
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		
		//3.create statement
		Statement statement= connection.createStatement();
		
		//4.execute statement
	   ResultSet result= statement.executeQuery("select * from employee");
		while(result.next())
		{
			System.out.println(result.getInt(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println("===================================");
			
			System.out.println(result.getInt("id")+"="+ result.getString("name"));
		}
		
		//5.close
		statement.close();
		
	}

}
