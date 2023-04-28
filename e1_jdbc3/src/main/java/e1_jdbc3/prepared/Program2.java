package e1_jdbc3.prepared;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program2 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter id");
		int id=s.nextInt();
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter phone");
		String number=s.next();
		System.out.println("Enter email");
		String email=s.next();
		//		1.load or register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//		2.establish connection
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		//3.create prepared statement
		PreparedStatement statement= connection.prepareStatement("update employee set name=?,phoneno=?,emailid=? where id=?");
		 statement.setInt(4, id);
		 statement.setString(1, name);
		 statement.setString(2, number);
		 statement.setString(3, email);
		 
		 //4.execute sattement
		 statement.execute();
		 
		 //5.close
		 connection.close();
		 System.out.println("data updated");
	}

}
