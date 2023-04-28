package e1_jdbc1.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program2 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("enter id");
		int id=s.nextInt();
		
		System.out.println("=======for updating  provide data below======");
		 System.out.println("enter name");
		 
		 String name=s.next();
		 
		 System.out.println("enter phone");
		 String phone=s.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		2.establish connection
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentjdbcdb", "root","root");
		
		//create statement
		
		PreparedStatement preparedStatement=connection.prepareStatement("update student set name=?,phone=? where id=?");
		preparedStatement.setInt(3, id);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, phone);
		
		//execute
		 preparedStatement.execute();
		 
		 //close
		 connection.close();
	}

}
