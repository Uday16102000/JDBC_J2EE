package e1_jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 
{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//1.load or register
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentjdbcdb", "root", "root");
	
		//3.create statement
		Statement statement= connection.createStatement();
		
		//4.execute statement
		
//		boolean result=statement.execute("select * from student");
//		System.out.println(result1);=====true(dql command)
//		statement.executeUpdate("select * from student");=== exception sql
		ResultSet result=statement.executeQuery("select * from student");
		while(result.next())
		{
			System.out.println(result.getInt(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println("===================================");
			
			System.out.println(result.getInt("id")+"="+ result.getString("name"));
		}
		//5.close
		connection.close();
		System.out.println(result);
		}

}
