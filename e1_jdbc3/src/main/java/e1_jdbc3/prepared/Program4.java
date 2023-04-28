package e1_jdbc3.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program4 {

public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the id please");
	int id=sc.nextInt();
	
//	1.load or registger
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//2.establish connection
	Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root", "root");
	
	//3.create statement
	PreparedStatement s= c.prepareStatement("select * from employee where id=?");
	s.setInt(1, id);
	//4.execute statement
	ResultSet result=s.executeQuery();
	while(result.next())
	{
		System.out.println(result.getInt(1));
		System.out.println(result.getString(2));
		System.out.println(result.getString(3));
		System.out.println("===================================");
		
		System.out.println(result.getInt("id" )+"="+ result.getString("name"));
	}
	
	
	//5.close
	c.close();
	
}

}
