package com.automation;

import java.util.Scanner;

public class Console {
	public void StartSystem() {
		AdminService adminService = new AdminService();
		WarehouseService warehouseService = new WarehouseService();
		BranchService branchService = new BranchService();
		BranchEmployeeService branchEmployeeService = new BranchEmployeeService();
		ProductService productService = new ProductService();
		TransportationEmployeeService transportationEmployeeService = new TransportationEmployeeService();
		UserService userService = new UserService();
		WarehouseEmployeeService warehouseEmployeeService = new WarehouseEmployeeService();

		Admin admin = new Admin("Fatih Erdoğan Sevilgen", "02626052210", "sevilgen@gtu.edu.tr", "1234");
		Warehouse warehouse = new Warehouse();
		Branch branch1 = new Branch("branch1", "Gebze", "02623333333");
		adminService.addBranch(branch1);
		Branch branch2 = new Branch("branch2", "İzmit", "02624444444");
		adminService.addBranch(branch2);
		BranchEmployee branchEmployee1 = new BranchEmployee("anyName1", "05321111111", "anyName1@abc.com", "1234", branch1.getId());
		adminService.addEmployee(branchEmployee1);
		BranchEmployee branchEmployee2 = new BranchEmployee("anyName2", "05323333333", "anyName2@abc.com", "1234", branch2.getId());
		adminService.addEmployee(branchEmployee2);
		WarehouseEmployee warehouseEmployee1 = new WarehouseEmployee("anyName3", "05324444444", "anyName3@abc.com", "1234", warehouse.getId());
		adminService.addEmployee(warehouseEmployee1);
		WarehouseEmployee warehouseEmployee2 = new WarehouseEmployee("anyName4", "05325555555", "anyName4@abc.com", "1234", warehouse.getId());
		adminService.addEmployee(warehouseEmployee2);
		TransportationEmployee transportationEmployee1 = new TransportationEmployee("anyName5", "05326666666", "anyName5@abc.com", "1234", branch1.getId());
		adminService.addEmployee(transportationEmployee1);
		TransportationEmployee transportationEmployee2 = new TransportationEmployee("anyName6", "05327777777", "anyName6@abc.com", "1234", branch1.getId());
		adminService.addEmployee(transportationEmployee2);
		Product product1 = new Product(warehouse.getId(), "anyProduct1", 100, ProductCategory.drinks);
		Product product2 = new Product(warehouse.getId(), "anyProduct2", 200, ProductCategory.drinks);
		Product product3 = new Product(branch1.getId(), "anyProduct3", 50, ProductCategory.drinks);
		Product product4 = new Product(branch2.getId(), "anyProduct4", 150, ProductCategory.drinks);

		Login(userService, adminService);
	}

	public void Login(UserService userService, AdminService adminService) {
		System.out.println("----------WAREHOUSE AUTOMATION SYSTEM----------");

		Scanner mailinput = new Scanner(System.in);
		String email = null;
		try {
			System.out.print("Enter Your Email address: ");
			email = mailinput.nextLine();
		} catch (Exception e) {
			System.out.print("Please enter a valid value!\n");
			mailinput.nextLine();
		}

		Scanner PassInput = new Scanner(System.in);
		String password = null;
		try {
			System.out.print("Enter Your Password: ");
			password = PassInput.nextLine();
		} catch (Exception e) {
			System.out.print("Please enter a valid value!\n");
			PassInput.nextLine();
		}

		Employee theEmployee = userService.login(email, password);

		if (theEmployee instanceof Admin) {
			AdminConsole((Admin) theEmployee, adminService);
		} else if (theEmployee instanceof BranchEmployee) {

		} else if (theEmployee instanceof WarehouseEmployee) {

		} else if (theEmployee instanceof TransportationEmployee) {

		}
	}

	public int getSubChoiceFromUser(int upperBound, String message){
		int choice;
		Scanner input = new Scanner(System.in);
		System.out.print(message);
		try {
			choice = input.nextInt();
			while (choice < 1 || choice > upperBound){
				choice=input.nextInt();
			}
		}
		catch (Exception e){
			choice=1;
			System.out.printf("Please enter a number between 1 and %d!\n", upperBound);
			input.nextLine();
		}
		return choice;
	}

	public String getStringFromUser(String message){
		Scanner input = new Scanner(System.in);
		String bName=null;
		System.out.print(message);
		try {
			bName = input.nextLine();
		}
		catch (Exception e){
			System.out.print("Please enter a valid value!\n");
			input.nextLine();
		}
		return bName;
	}

	public static int getNumberFromUser(String message){
		int choice;
		Scanner input = new Scanner(System.in);
		System.out.print(message);
		try {
			choice = input.nextInt();
			if(choice == -1)
				return -1;
			while (choice<1 && choice != -1){
				System.out.print("Please enter a number bigger than 0: ");
				choice=input.nextInt();
			}
		}
		catch (Exception e){
			choice=1;
			System.out.println("Please enter a number!");
			input.nextLine();
		}
		return choice;
	}

	public void AdminConsole(Admin admin, AdminService adminService) {
		while(true) {
			System.out.println("WELCOME " + admin.getName() + "\n");
			System.out.println("1- List Employees");
			System.out.println("2- List Pending Approvals");
			System.out.println("3- Add an Employee");
			System.out.println("4- Remove an Employee");
			System.out.println("5- List Branches");
			System.out.println("6- Add a Branch");
			System.out.println("7- Remove a Branch");
			System.out.println("8- List Products");
			System.out.println("9- Add a Product");
			System.out.println("10- Remove a Product");
			System.out.println("8- List Shipments");

			int choice = getSubChoiceFromUser(10, "Your Choice: ");

			switch (choice) {
				case 1:
					for (Employee employee : adminService.getEmployees().values()) {
						System.out.println("" + employee.getId() + " - " + employee.getName()
								+ " - " + employee.getEmail() + " - " + employee.getPhone());
					}
					break;
				case 2:
					for (Employee employee : adminService.getWaitingApprovals()) {
						System.out.println("" + employee.getId() + " - " + employee.getName()
								+ " - " + employee.getEmail() + " - " + employee.getPhone());
					}
					break;
				case 3:
					System.out.println("1- Branch Employee");
					System.out.println("2- Warehouse Employee");
					System.out.println("3- Transportation Employee");

					int choice2 = getSubChoiceFromUser(3, "Which Employee Do You Want To Add?");

					String name, email, phone, password;
					switch (choice2) {
						case 1:
							name = getStringFromUser("Name: ");
							phone = getStringFromUser("Phone: ");
							email = getStringFromUser("Email: ");
							password = getStringFromUser("Password: ");
							int branchId = getNumberFromUser("Branch ID: ");

							BranchEmployee employee = new BranchEmployee(name, phone, email, password, branchId);
							adminService.addEmployee(employee);
							break;
						case 2:
							name = getStringFromUser("Name: ");
							phone = getStringFromUser("Phone: ");
							email = getStringFromUser("Email: ");
							password = getStringFromUser("Password: ");
							int warehouseId = getNumberFromUser("Warehouse ID: ");

							WarehouseEmployee employee1 = new WarehouseEmployee(name, phone, email, password, warehouseId);
							adminService.addEmployee(employee1);
							break;
						case 3:

							break;
					}
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
			}
		}
	}

	public void BranchEmployeeConsole() {

	}

	public void WarehouseEmployeeConsole() {

	}

	public void TransportationEmployeeConsole() {

	}
}
