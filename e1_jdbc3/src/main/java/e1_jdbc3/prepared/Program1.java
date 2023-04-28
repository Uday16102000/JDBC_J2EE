package e1_jdbc3.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program1
{
public static void main(String[] args) throws ClassNotFoundException, SQLException
{   Scanner s= new Scanner(System.in);
    System.out.println("Enter id");
    int id= s.nextInt();
    System.out.println("Enter  name");
    String name=s.next();
    System.out.println("Enter phone number");
    String number=s.next();
    System.out.println("Enter email id");
    String email=s.next();
    //1.load or register
	Class.forName("com.mysql.cj.jdbc.Driver");
	//2.establish connection
	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root", "root");
	//create statement
	PreparedStatement statement=connection.prepareStatement("insert into employee values(?,?,?,?)");
	statement.setInt(1,id);
	statement.setString(2, name);
	statement.setString(3, number);
	statement.setString(4, email);
	//execute statement
	statement.execute();
	//close
	connection.close();
	System.out.println("inserted " + " "+" data");
	
}
}
