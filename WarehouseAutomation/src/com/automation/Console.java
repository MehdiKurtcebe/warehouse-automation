package com.automation;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import static com.automation.ProductCategory.*;

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

	public void BranchEmployeeConsole(BranchEmployeeService branchEmployeeService) {

		WarehouseService warehouseService = new WarehouseService();

		System.out.println("Welcome to Branch Employee Console");

		Scanner scan = new Scanner(System.in);
		int choice = -1;

		String name;
		String phone;
		String email;
		String password;
		int id;
		int branchId;

		Shipment shipment;

		while(choice != 0){
			System.out.println("-----MENU-----");
			System.out.println("0- Exit");
			System.out.println("1- Create shipment request");
			System.out.println("2- Check if a branch has a specific product");
			System.out.println("3- See shipment by ID");
			System.out.println("4- See shipment History");
			System.out.println("5- Create supply request");
			System.out.println("6- See a branch employee's information");
			System.out.println("Please choose an operation: ");
			choice = scan.nextInt();

			switch(choice){
				case 0:
					break;

				case 1:
					BinarySearchTree<Product> productList = new BinarySearchTree<Product>();
					int count;
					System.out.println("How many products do you want to request?");
					count = scan.nextInt();

					Product product;

					for(int i=0; i<count; i++){
						System.out.println("Enter the product's id");
						id = scan.nextInt();

						product = warehouseService.searchProductById(id);
						productList.add(product);
					}

					break;

				case 2:
					System.out.println("Enter the ID of the branch you want to see the products of:");
					branchId = scan.nextInt();
					BinarySearchTree<Product> productList1;
					productList1 = branchEmployeeService.getProductList(branchId);
					System.out.println("Enter the ID of the product you want to check if the branch has:");
					int productId = scan.nextInt();
					Product target = branchEmployeeService.getProductById(productId);
					if(productList1.find(target) != null)   System.out.println("Branch " + branchId + " has product " + productId);
					else    System.out.println("Branch " + branchId + " does not have product " + productId);

					break;

				case 3:
					System.out.println("Enter the ID of the shipment you want to see the products of:");
					int shipmentId = scan.nextInt();
					System.out.println("Enter the ID of the branch:");
					branchId = scan.nextInt();
					shipment = branchEmployeeService.getShipmentById(shipmentId, branchId);
					List<Product> productList2;
					productList2 = shipment.getProductList();
					for(int i=0; i<productList2.size(); i++){
						System.out.println("Product " + i+1 + "'s ID: " + productList2.get(i).getId());
						System.out.println("Product " + i+1 + "'s name: " + productList2.get(i).getName());
						System.out.println("Product " + i+1 + "'s stock count: " + productList2.get(i).getStockCount());
						System.out.println("Product " + i+1 + "'s category: " + productList2.get(i).getCategory());
					}

					break;

				case 4:
					System.out.println("Enter the ID of the branch you want to see the shipment history of");
					branchId = scan.nextInt();
					PriorityQueue<Shipment> shipmentHistory;
					shipmentHistory = branchEmployeeService.getShipmentHistory(branchId);
					int i = 0;
					while(shipmentHistory.size() > 0){
						Shipment shipment1 = shipmentHistory.poll();
						System.out.println("Shipment " + i + "'s ID: " + shipment1.getId());
						System.out.println("Shipment " + i + "'s transportation employee's ID: " + shipment1.getEmployee());
						System.out.println("Shipment " + i + "'s shipment status: " + shipment1.getStatus());
						System.out.println("Shipment " + i + "'s product list: ");
						List<Product> productList3;
						productList3 = shipment1.getProductList();
						for(int j=0; j<productList3.size(); j++){
							System.out.println("\tProduct " + j+1 + "'s ID: " + productList3.get(j).getId());
							System.out.println("\tProduct " + j+1 + "'s name: " + productList3.get(j).getName());
							System.out.println("\tProduct " + j+1 + "'s stock count: " + productList3.get(j).getStockCount());
							System.out.println("\tProduct " + j+1 + "'s category: " + productList3.get(j).getCategory());
						}
					}
					break;

				case 5:
					BinarySearchTree<Product> productList4 = new BinarySearchTree<Product>();
					System.out.println("Which branch do you want to add the products to?");
					branchId = scan.nextInt();
					System.out.println("How many products do you want to enter?");
					count = scan.nextInt();

					int stock;
					ProductCategory category;
					String sCategory;

					for(i=0; i<count; i++){
						System.out.println("Enter the product's name");
						name = scan.nextLine();
						System.out.println("Enter the product's stock count");
						stock = scan.nextInt();
						System.out.println("Enter the product's category");
						sCategory = scan.nextLine();

						category = ProductCategory.valueOf(sCategory);

						product = new Product(branchId, name, stock, category);
						productList4.add(product);
					}

					break;

				case 6:
					System.out.println("Enter the branchEmployee's ID: ");
					id = scan.nextInt();
					branchEmployeeService.toString(id);

					break;

				default:
					System.out.println("You entered an invalid number.");
					System.out.println("Please choose another operation");
			}
		}
	}

	public void WarehouseEmployeeConsole() {

	}

	public void TransportationEmployeeConsole() {

	}
}
