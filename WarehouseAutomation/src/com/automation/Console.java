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

		Login(userService);
	}

	public void Login(UserService userService) {
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

		} else if (theEmployee instanceof BranchEmployee) {

		} else if (theEmployee instanceof WarehouseEmployee) {

		} else if (theEmployee instanceof TransportationEmployee) {

		}
	}

	public void AdminConsole() {

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
					
					System.out.println("Shipment request is created successfully");

					break;

				case 2:
					System.out.println("Enter the ID of the branch you want to see the products of:");
					branchId = scan.nextInt();
					BinarySearchTree<Product> productList;
					productList = branchEmployeeService.getProductList(branchId);
					System.out.println("Enter the ID of the product you want to check if the branch has:");
					int productId = scan.nextInt();
					if(productList.find(productId) != null)   System.out.println("Branch " + branchId + " has product " + productId);
					else    System.out.println("Branch " + branchId + " does not have product " + productId);

					break;

				case 3:
					System.out.println("Enter the ID of the shipment you want to see the products of:");
					int shipmentId = scan.nextInt();
					System.out.println("Enter the ID of the branch:");
					branchId = scan.nextInt();
					shipment = branchEmployeeService.getShipmentById(shipmentId, branchId);
					List<Product> productList;
					productList = shipment.getProductList();
					for(int i=0; i<productList.size(); i++){
						System.out.println("Product " + i+1 + "'s ID: " + productList.get(i).getId());
						System.out.println("Product " + i+1 + "'s name: " + productList.get(i).getName());
						System.out.println("Product " + i+1 + "'s stock count: " + productList.get(i).getStockCount());
						System.out.println("Product " + i+1 + "'s category: " + productList.get(i).getCategory());
					}

					break;

				case 4:
					System.out.println("Enter the ID of the branch you want to see the shipment history of");
					branchId = scan.nextInt();
					PriorityQueue<Product> shipmentHistory;
					shipmentHistory = branchEmployeeService.getShipmentHistory(branchId);
					for(int i=1; shipmentHistory.peek(); i++){
						System.out.println("Shipment " + i + "'s ID: " + shipmentHistory.poll().getId());
						System.out.println("Shipment " + i + "'s transportation employee's ID: " + shipmentHistory.poll().getEmployee());
						System.out.println("Shipment " + i + "'s shipment status: " + shipmentHistory.poll().getStatus());
						System.out.println("Shipment " + i + "'s product list: ");
						List<Product> productList;
						productList = shipment.getProductList();
						for(int j=0; j<productList.size(); j++){
							System.out.println("\tProduct " + j+1 + "'s ID: " + productList.get(j).getId());
							System.out.println("\tProduct " + j+1 + "'s name: " + productList.get(j).getName());
							System.out.println("\tProduct " + j+1 + "'s stock count: " + productList.get(j).getStockCount());
							System.out.println("\tProduct " + j+1 + "'s category: " + productList.get(j).getCategory());
						}
					}

					break;

				case 5:
					BinarySearchTree<Product> productList = new BinarySearchTree<Product>();
					int count;
					System.out.println("Which branch do you want to add the products to?");
					branchId = scan.nextInt();
					System.out.println("How many products do you want to enter?");
					count = scan.nextInt();

					Product product;

					String name;
					int stock;
					ProductCategory category;

					for(int i=0; i<count; i++){
						System.out.println("Enter the product's name");
						name = scan.nextLine();
						System.out.println("Enter the product's stock count");
						stock = scan.nextInt();
						System.out.println("Enter the product's category");
						category = scan.nextLine();

						product = new Product(branchId, name, stock, category);
						productList.add(product);
					}
					
					System.out.println("Supply request is created successfully");

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
