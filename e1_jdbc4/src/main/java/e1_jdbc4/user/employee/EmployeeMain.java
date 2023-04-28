package e1_jdbc4.user.employee;
import java.util.Scanner;



public class EmployeeMain 
     
{
	
		
	

	public static void main(String[] args) throws Exception {
		EmployeeCrud crud= new EmployeeCrud();
		Scanner sc= new Scanner(System.in);
		boolean check=true;
		do {
		System.out.println("choose your option \n 1.save \n 2.update \n 3.delete \n 4.retrieve by id \n 5.retriueve all"
				+ "\n 6.login \n 7.exit");
		int choice =sc.nextInt();
		
		
		switch(choice) {
		case 1:{
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter phone");
			String phone=sc.next();
			System.out.println("Enter emailid");
			String emailid=sc.next();
			Employee emp= new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setPhone(phone);
			emp.setEmailid(emailid);
			crud.saveEmployee(emp);
			
			
			
			System.out.println("**********Inserted***********");
			
		}break;
		
		case 2:{
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter phone");
			String phone=sc.next();
			System.out.println("Enter id");
			int id=sc.nextInt();
			Employee emp= new Employee();
			emp.setName(name);
			emp.setPhone(phone);
			emp.setId(id);
			crud.updateEmployee(emp);
			System.out.println("************Updated*************");
			
			
		}break;
		case 3:{
		
			System.out.println("Enter id");
			int id=sc.nextInt();
			crud.deleteEmployee(id);
			System.out.println("************Deleted*************");
			
			
		}break;
		
		case 4:{
			
			crud.retrieveUser();
			
		}break;
		default:check=false;
		break;
		}
		}while(check);
		System.out.println("Thank You");
		
	}

}
