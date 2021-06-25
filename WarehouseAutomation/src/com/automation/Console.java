package com.automation;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Console {
	public static void StartSystem() {
		AdminService adminService = new AdminService();
		WarehouseService warehouseService = new WarehouseService();
		BranchService branchService = new BranchService();
		BranchEmployeeService branchEmployeeService = new BranchEmployeeService();
		ProductService productService = new ProductService();
		TransportationEmployeeService transportationEmployeeService = new TransportationEmployeeService();
		UserService userService = new UserService();
		WarehouseEmployeeService warehouseEmployeeService = new WarehouseEmployeeService();

		Admin admin = new Admin("Fatih Erdoğan Sevilgen", "02626052210", "sevilgen@gtu.edu.tr", "1234");
		adminService.addEmployee(admin);
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
		TransportationEmployee transportationEmployee1 = new TransportationEmployee("anyName5", "05326666666", "anyName5@abc.com", "1234", branch1.getId(), 50);
		adminService.addEmployee(transportationEmployee1);
		TransportationEmployee transportationEmployee2 = new TransportationEmployee("anyName6", "05327777777", "anyName6@abc.com", "1234", branch1.getId(), 25);
		adminService.addEmployee(transportationEmployee2);
		BranchEmployee pendingEmployee1 = new BranchEmployee("pending1", "05421111111", "pending1@abc.com", "1234", branch1.getId());
		adminService.addEmployeeToApproval(pendingEmployee1);
		Product product1 = new Product(warehouse.getId(), "anyProduct1", 100, ProductCategory.drinks);
		adminService.addProduct(product1);
		Product product2 = new Product(warehouse.getId(), "anyProduct2", 200, ProductCategory.drinks);
		adminService.addProduct(product2);
		Product product3 = new Product(branch1.getId(), "anyProduct3", 50, ProductCategory.drinks);
		adminService.addProduct(product3);
		Product product4 = new Product(branch2.getId(), "anyProduct4", 150, ProductCategory.drinks);
		adminService.addProduct(product4);
		warehouseService.supplyProduct(product1, branch2.getId());
		warehouseService.supplyProduct(product2, branch2.getId());

		Login();
	}

	private static void Login() {
		UserService userService = new UserService();
		AdminService adminService = new AdminService();
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

			WarehouseEmployeeConsole((WarehouseEmployee)theEmployee);

		} else if (theEmployee instanceof TransportationEmployee) {
			TransportationEmployeeConsole((TransportationEmployee)theEmployee );
		} else {
			System.out.println("Invalid Email or Password! Please Try Again.");
			Login();
		}
	}

	private static int getSubChoiceFromUser(int upperBound, String message){
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

	private static String getStringFromUser(String message){
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

	private static int getNumberFromUser(String message){
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

	private static void AdminConsole(Admin admin, AdminService adminService) {
		while(true) {
			System.out.println("\n------------------------------");
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
			System.out.println("11- List Shipments");

			int choice = getSubChoiceFromUser(11, "Your Choice: ");

			switch (choice) {
				case 1:
					System.out.println("\n------------------------------");
					for (Employee employee : adminService.getEmployees().values()) {
						System.out.println("" + employee.getName() + " - " + employee.getId()
								+ " - " + employee.getEmail() + " - " + employee.getPhone());
					}
					break;
				case 2:
					System.out.println("\n------------------------------");
					for (Employee employee : adminService.getWaitingApprovals()) {
						System.out.println("" + employee.getName() + " - " + employee.getId()
								+ " - " + employee.getEmail() + " - " + employee.getPhone());
					}
					break;
				case 3:
					System.out.println("\n------------------------------");
					System.out.println("1- Branch Employee");
					System.out.println("2- Warehouse Employee");
					System.out.println("3- Transportation Employee");

					int choice2 = getSubChoiceFromUser(3, "Which Employee Do You Want To Add? ");

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
							name = getStringFromUser("Name: ");
							phone = getStringFromUser("Phone: ");
							email = getStringFromUser("Email: ");
							password = getStringFromUser("Password: ");
							int branchId1 = getNumberFromUser("Branch ID: ");
							int distance = getNumberFromUser("The Distance Between the Branch and the Warehouse: ");

							TransportationEmployee employee2 = new TransportationEmployee(name, phone, email, password, branchId1, distance);
							adminService.addEmployee(employee2);
							break;
					}
					break;
				case 4:
					System.out.println("\n------------------------------");
					int id = getNumberFromUser("Enter the ID of the Employee: ");
					adminService.removeEmployee(id);
					break;
				case 5:
					System.out.println("\n------------------------------");
					for (Branch branch : adminService.getBranches().values()) {
						System.out.println("" + branch.getName() + " - " + branch.getId()
								+ " - " + branch.getAddress() + " - " + branch.getPhone());
					}
					break;
				case 6:
					System.out.println("\n------------------------------");
					String name1 = getStringFromUser("Name: ");
					String address = getStringFromUser("Address: ");
					String phone1 = getStringFromUser("Phone: ");

					Branch branch = new Branch(name1, address, phone1);
					adminService.addBranch(branch);
					break;
				case 7:
					System.out.println("\n------------------------------");
					int id1 = getNumberFromUser("Enter the ID of the Branch: ");
					adminService.removeBranch(id1);
					break;
				case 8:
					System.out.println("\n------------------------------");
					for (Product product : adminService.getProducts()) {
						String branchName = adminService.queryBranchById(product.getStoreId()) != null ?
								adminService.queryBranchById(product.getStoreId()).getName() : "Warehouse";
						System.out.println("" + product.getName() + " - " + product.getId()
								+ " - " + branchName + " - Stock: " + product.getStockCount() + " - " + product.getCategory());
					}
					break;
				case 9:
					System.out.println("\n------------------------------");
					String name2 = getStringFromUser("Name: ");
					int stock = getNumberFromUser("Stock Count: ");
					int storeId = getNumberFromUser("Branch ID: ");

					Product product = new Product(storeId, name2, stock, ProductCategory.drinks);
					adminService.addProduct(product);
					break;
				case 10:
					System.out.println("\n------------------------------");
					int productId = getNumberFromUser("Product ID: ");
					adminService.removeProduct(productId);
					break;
				case 11:
					System.out.println("\n------------------------------");
					for (Shipment shipment : adminService.getShipments()) {
						String branchName =	adminService.queryBranchById(shipment.getBranchId()).getName();
						System.out.println("" + shipment.getProductList() + " - " + shipment.getId() + " - " + shipment.getStatus()
								+ " - " + branchName + " - Transporter: " + shipment.getEmployee().getName());
					}
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


	public static void WarehouseEmployeeConsole(WarehouseEmployee wareHouseEmp) {
		
		WarehouseEmployeeService warehouseEmployeeService = new WarehouseEmployeeService();
		Warehouse warehouse = new Warehouse();
		
		
		System.out.println("1-List Product");
		System.out.println("2-List Shipments");
		System.out.println("3-Get Shipment Information");
		System.out.println("4-Search Product");
		System.out.println("5-Log Out");
		
		int choice = getSubChoiceFromUser(5, "Select: ");
		switch(choice){
		
			case 1: for(Product product : warehouseEmployeeService.getProductList() )
						System.out.println(product);
			break;
			
			case 2:
				for(Shipment shipment: warehouse.getShipments())
						System.out.println(shipment);
				break;
			
			case 3:
				int shipId = getNumberFromUser("Enter Shipment Id");
				Shipment ship = warehouseEmployeeService.getShipmentInformation(shipId);
				if(ship == null){
					System.out.println("Wrong Id");
				}
				else 
					System.out.println(ship);
				break;
				
				
			case 4: 
				int productId = getNumberFromUser("Enter product Id");
				Product product = warehouseEmployeeService.searchProduct(productId);
				if(product == null){
					System.out.println("Wrong Id");
				}
				else 
					System.out.println(product);
				break;
				
				
			case 5: break;
		}
		
	}


	public static void TransportationEmployeeConsole(TransportationEmployee transportationEmployee) {

		WarehouseService warehouseService = new WarehouseService();


		System.out.println("WELCOME "+ transportationEmployee.getName() + "\n");
		System.out.println("1- Show My Shipment");
		System.out.println("2- Update Shipment Status");
		System.out.println("3- Log Out");

		int choice = getSubChoiceFromUser(3,"Your Choice: ");
		switch (choice) {
			case 1 :
				for(Shipment shipment : transportationEmployee.getMyShipments())
					System.out.println(shipment);
				TransportationEmployeeConsole(transportationEmployee);
				break;


			case 2 :
				Scanner scanner = new Scanner(System.in);
				Shipment shipment = null;
				do {
					System.out.println("Enter Shipment Id (Cancel: -1)");
					int shipmentId = scanner.nextInt();
					if(shipmentId == -1) {
						TransportationEmployeeConsole(transportationEmployee);
						System.out.println("");
						break;
					}
					shipment = warehouseService.getShipmentById(shipmentId);
					if(shipment == null)
						System.out.println("Shipment Id is wrong try again");
				}while(shipment == null);

				ShipmentStatus shipStatus = ShipmentStatus.NONE;
				int status = getSubChoiceFromUser(3,"1-Packed \n2-Shipped \n3-Delivered");

				if(status == 1)
					shipStatus = ShipmentStatus.PACKED;
				else if(status == 2)
					shipStatus = ShipmentStatus.SHIPPED;
				else if(status == 3)
					shipStatus = ShipmentStatus.DELIVERED;

				warehouseService.updateShipmentStatus(shipment.getId(), shipStatus);

				System.out.println("The shipment updated");
				TransportationEmployeeConsole(transportationEmployee);
				break;

			case 3 : Login();

		}






	}
}