package e1_jdbc4.user.employee;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

public class EmployeeCrud 
{
	public Connection getConnection() throws Exception{
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	FileInputStream stream= new FileInputStream("file.properties");
	Properties properties=new Properties();
   properties.load(stream);
   Connection c= DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("pwd"));
   return c;
	}
	public void saveEmployee(Employee emp) throws Exception
	{
		Connection c=getConnection();
		PreparedStatement s= c.prepareStatement("insert into employee2 values(?,?,?,?)");
		s.setInt(1, emp.getId());
		s.setString(2,emp.getName());
		s.setString(3, emp.getPhone());
		s.setString(4, emp.getEmailid());
		s.execute();
		c.close();
		
		
	}
	
	public void updateEmployee(Employee emp)throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2","root","root");
		PreparedStatement s= c.prepareStatement("update employee2 set name=?,phone=? where id=?");
		s.setString(1, emp.getName());
		s.setString(2, emp.getPhone());
		s.setInt(3, emp.getId());
		s.execute();
		c.close();
		
	}
	public void deleteEmployee(int id) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2","root","root");
		PreparedStatement s= c.prepareStatement("delete from employee2 where id=?");
		s.setInt(1,id);
		s.execute();
		c.close();
		
	}
	public void retrieveUser()throws  Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb2","root","root");
		PreparedStatement s= c.prepareStatement("select * from employee2");
		ResultSet result= s.executeQuery();
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
