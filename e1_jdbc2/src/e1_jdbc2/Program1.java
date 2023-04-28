package e1_jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	//1.load or register
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//2.establish connection
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentjdbcdb","root" , "root");
//	 3.create statement
	Statement statement =connection.createStatement();
//	4.execute statement
	statement.execute("update student set name='rakesh' where id=1");
	
//	5.close
	connection.close();
	statement.close();
	
}
}
