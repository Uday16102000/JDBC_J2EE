package e1_jdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCrud 
{
	//creating a method for saving user ibject
public void saveUser(User user) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root", "root");
	PreparedStatement statement=connection.prepareStatement("insert into user values(?,?,?,?,?)");
	statement.setInt(1, user.getId());
	statement.setString(2, user.getName());
	statement.setString(3, user.getEmail());
	statement.setString(4, user.getContact());
	statement.setString(5,user.getPwd());
	statement.execute();
	connection.close();
	
	
}

//creating a method for update of email and phone
public void updateUser(User user) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root", "root");
	PreparedStatement statement=connection.prepareStatement("update user set email=?,contact=? where  id=?");
	statement.setString(1, user.getEmail());
	statement.setString(2, user.getContact());
	statement.setInt(3, user.getId());
	statement.execute();
	connection.close();
	
	
	
}

//creating a method for deleting 
 public void deleteUser(String name) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root", "root");
		PreparedStatement statement=connection.prepareStatement("delete from user where name=?");
		statement.setString(1, name);
		statement.execute();
		connection.close();
		
		
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
 public void retrieveUser() throws Exception
 {
	 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root", "root");
		PreparedStatement statement=connection.prepareStatement("select * from user");
ResultSet result= statement.executeQuery();
while(result.next())
{
	System.out.println(result.getInt(1));
	System.out.println(result.getString(2));
	System.out.println(result.getString(3));
	System.out.println(result.getString(4));
	
	System.out.println("=========");
}
		
 }

}
