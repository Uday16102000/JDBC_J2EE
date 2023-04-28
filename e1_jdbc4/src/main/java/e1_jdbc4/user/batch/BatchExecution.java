package e1_jdbc4.user.batch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import e1_jdbc4.User;
public class BatchExecution {
public static void main(String[] args) throws Exception
{
User user4 = new User();
	user4.setId(293);
	user4.setName("uday");
	user4.setEmail("u@gamil.com");
	user4.setContact("456789");
	user4.setPwd("123");
User user2 = new User();
	user2.setId(20);
	user2.setName("karan");
	user2.setEmail("k@gamil.com");
	user2.setContact("45678");
	user2.setPwd("345");
User user3 = new User();
	user3.setId(233);
	user3.setName("dinga");
	user3.setEmail("dinaga@gamil.com");
	user3.setContact("45678");
	user3.setPwd("345");
List<User> list = new ArrayList<User>();
	list.add(user3);
	list.add(user2);
	list.add(user4);
	// 1.load
	Class.forName("com.mysql.cj.jdbc.Driver");
	// establish the connection
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");

	// creation of statement

	PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?,?,?)");
   for(User user :list)
   {
	   statement.setInt(1, user.getId());
statement.setString(2, user.getName());
statement.setString(3, user.getEmail());
//statement.setString(4, user.getContact());
statement.setString(4, user.getPwd());
statement.setString(5, user.getContact());
System.out.println("inserted");
statement.addBatch();

   }
   statement.executeBatch();
//    statement.execute();
   connection.close();
}

//
//User user4 = new User();
//user4.setId(15);
//user4.setName("uday");
//user4.setEmail("u@gamil.com");
//user4.setContact("456789");
//user4.setPwd("123");
//
//User user2 = new User();
//user2.setId(14);
//user2.setName("venu");
//user2.setEmail("venu@gamil.com");
//user2.setContact("45678");
//user2.setPwd("345");
//
//User user3 = new User();
//user3.setId(16);
//user3.setName("dinga");
//user3.setEmail("dinaga@gamil.com");
//user3.setContact("45678");
//user3.setPwd("345");
//
//List<User> list = new ArrayList<User>();
//list.add(user3);
//list.add(user2);
//list.add(user4);
//
//// 1.load
//Class.forName("com.mysql.cj.jdbc.Driver");
//// establish the connection
//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
//
//// creation of statement
//
//PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?,?,?)");
//
//for (User user : list) {
//	statement.setInt(1, user.getId());
//	statement.setString(2, user.getName());
//	statement.setString(3, user.getEmail());
//	statement.setString(4, user.getContact());
//	statement.setString(5, user.getPwd());
//	System.out.println("inserted"+user.getName());
//
//	statement.addBatch();
//
//}
//
//statement.executeBatch();
//
//// execute the statement
////statement.execute();
//// close the connection
//connection.close();

}

