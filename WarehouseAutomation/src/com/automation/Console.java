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

	public void BranchEmployeeConsole() {

	}

	public void WarehouseEmployeeConsole() {

	}

	public void TransportationEmployeeConsole() {

	}
}
