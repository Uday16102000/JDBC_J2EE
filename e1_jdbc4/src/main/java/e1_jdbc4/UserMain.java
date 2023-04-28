package e1_jdbc4;
import java.util.Scanner;

public class UserMain 
{
public static void main(String[] args)throws Exception {
	UserCrud crud= new UserCrud();
	Scanner sc= new Scanner(System.in);
	boolean check=true;
	
	//to execute the code later it can check on the condition
	do {
		System.out.println("choose your choice \n 1.save \n 2.update \n 3.delete \n 4.retrieve \n 5.exit");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:{

			System.out.println("enter your id");
			int id=sc.nextInt();
			System.out.println("enter your name");
			String name=sc.next();
			System.out.println("enter your  email");
			String email=sc.next();
//			System.out.println("enter your phone");
//			String contact=sc.next();
			
			System.out.println("enter your pwd ");
			String pwd=sc.next();
			System.out.println("enter your phone");
			String contact=sc.next();
			
			User user= new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
//			user.setContact(contact);
			user.setPwd(pwd);
			user.setContact(contact);
			
			crud.saveUser(user);
			
			System.out.println("****User saved/inserted**********");
		}
		
		
		break;
		case 2:
		{
			System.out.println("enter your id");
			int id=sc.nextInt();
		
			System.out.println("enter your  email");
			String email=sc.next();
			
			System.out.println("enter your phone");
			String contact=sc.next();
			User user= new User();
			user.setId(id);
			
			user.setEmail(email);
//			user.setContact(contact);
			
			user.setContact(contact);
			crud.updateUser(user);
			System.out.println("==========updated=====");
		}
		break;
		
		case 3:
		{
			System.out.println("Enter id");
			String name=sc.next();
			crud.deleteUser(name);
			System.out.println("=====deleted======");
			
		}break;
		
		case 4:
		{
			
			crud.retrieveUser();
		}
			
		break;
		default:check=false;
		break;
		}
		
		
		
		
		
		
		
		
		
		
		
	} while (check);
	System.out.println("Thank You");
	
	//asking user to provide data to save
//	System.out.println("enter your id");
//	int id=sc.nextInt();
//	System.out.println("enter your name");
//	String name=sc.next();
//	System.out.println("enter your  email");
//	String email=sc.next();
////	System.out.println("enter your phone");
////	String contact=sc.next();
//	
//	System.out.println("enter your pwd ");
//	String pwd=sc.next();
//	System.out.println("enter your phone");
//	String contact=sc.next();
//	
//	User user= new User();
//	user.setId(id);
//	user.setName(name);
//	user.setEmail(email);
////	user.setContact(contact);
//	user.setPwd(pwd);
//	user.setContact(contact);
//	
//	crud.saveUser(user);
//	boolean check=true;
	
	//creating a method for update user phone and email
	


}
}
