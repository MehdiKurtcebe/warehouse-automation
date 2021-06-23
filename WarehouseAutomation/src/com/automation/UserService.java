package com.automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.Scanner;


public class UserService implements IUserService {
	
    private static ConcurrentSkipListMap<Integer,Employee> employeeList;
    private IAdminService adminService;
    
    
    public UserService(){
   
    	if(employeeList == null)
    		employeeList = new ConcurrentSkipListMap<Integer, Employee>();
    	
        this.adminService = new AdminService();
    }

    @Override
    public Employee login(String email, String password) {
        for(Employee e: employeeList.values())
        	if(e.getEmail().equals(email) && e.getPassword().equals(password))
        		return e;
        return null;
    }

    @Override
    public boolean signUp(String name, String phone, String email, String password, UserType userType) {
        //confirm user parameters
        //create employee with given userType
        //send it to admin approval
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addUser(Employee employee) {
    	if(employeeList.containsKey(employee.getId()))
    		return false;
        employeeList.put(employee.getId(), employee);
      
        return true;
    }

    @Override
    public boolean removeUser(Employee employee) {
        if( employeeList.remove(employee.getId()) != null ){
       
        	return true;
        }
        return false;
    }
  
  
    

    public static void loginMenu() {
    	
    	UserService userService = new UserService();
    	
    	Scanner scanner = new Scanner(System.in);
   
    	Employee user = null;
    	while(user == null) {
    		
    		System.out.println("Enter your e-mail: ");
        	String mail = scanner.nextLine();
        	
        	System.out.println("Enter your password: ");
        	String password = scanner.nextLine();
        	
        	user = userService.login(mail, password);
        	
    		if (user == null) 
    			System.out.println("The mail or password is wrong please try again.");
    	}
    	
    	
    }
    
    public static void main(String[] args) {
    	UserService userService = new UserService();
    	WarehouseEmployee emp1 = new WarehouseEmployee("ali", "yilmaz", "test@test.com", "12345678", 1);
    	WarehouseEmployee emp2 = new WarehouseEmployee("veli", "seker", "test2@test.com", "12345678", 2);
    	userService.addUser(emp1);
    	userService.addUser(emp2);
    	
    }
    
}