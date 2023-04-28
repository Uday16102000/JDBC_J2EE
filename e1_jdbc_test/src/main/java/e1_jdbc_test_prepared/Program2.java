package e1_jdbc_test_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 
{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		1.load or register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentjdbcdb1", "root", "root");
		
		//3.create statement
		Statement statement= connection.createStatement();
		
		//4.execute statement
		int a=statement.executeUpdate("update student1 set name='karan', email='karan@gmail.com' where id=1");
		System.out.println(a);
		
		//5.close
		statement.close();
		connection.close();
		
		
		
	}

}
