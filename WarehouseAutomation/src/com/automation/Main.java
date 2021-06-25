package com.automation;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Console.StartSystem();
/*
        Scanner scan = new Scanner(System.in);

        System.out.println("How many branch employees you want to enter?");
        int numOfBranchEmployees = scan.nextInt();

        BranchEmployee[] branchEmployees = new BranchEmployee[];

        String name;
        String phone;
        String email;
        String password;
        int branchId;

        BranchEmployeeService branchEmployeeService = new BranchEmployeeService();

        for(int i=0; i<numOfBranchEmployees; i++){
            System.out.println("Enter the name and surname of branch employee " + i+1);
            name = scan.nextLine();

            System.out.println("Enter the phone of branch employee " + i+1);
            phone = scan.nextLine();

            System.out.println("Enter the email of branch employee " + i+1);
            email = scan.nextLine();

            System.out.println("Enter the password of branch employee " + i+1);
            password = scan.nextLine();

            System.out.println("Enter the branch id of branch employee " + i+1);
            branchId = scan.nextInt();

            branchEmployees[i] = new BranchEmployee(name, phone, email, password, branchId);
        }

        for(int i=0; i<numOfBranchEmployees; i++){
            System.out.println("Branch employee " + i+1 + "'s name is " + branchEmployees[i].getName());
            System.out.println("Branch employee " + i+1 + "'s phone is " + branchEmployees[i].getPhone());
            System.out.println("Branch employee " + i+1 + "'s email is " + branchEmployees[i].getEmail());
            System.out.println("Branch employee " + i+1 + "'s password is " + branchEmployees[i].getPassword());
            System.out.println("Branch employee " + i+1 + "'s ID is " + branchEmployees[i].getId());
            System.out.println("Branch employee " + i+1 + "'s branch ID is " + branchEmployees[i].getBranchId());
        }

        System.out.println("Enter the ID of the branch you want to check the products of:");
        branchId = scan.nextInt();

        System.out.println("Enter the ID of the product you want to check if the branch has:");
        int productId = scan.nextInt();

        BinarySearchTree<Product> productList = new BinarySearchTree<Product>();
        productList = branchEmployeeService.getProductList(branchId);

        if(productList.search(productId) != null)   System.out.println("Branch " + branchId + " has product " + productId);
        else    System.out.println("Branch " + branchId + " does not have product " + productId);

        System.out.println("Enter the ID of the shipment you want to see the products of:");
        int shipmentId = scan.nextInt();

        System.out.println("Enter the ID of the branch:");
        branchId = scan.nextInt();

        Shipment shipment;
        shipment = branchEmployeeService.getShipmentById(shipmentId, branchId);

        List<Product> productList1;
        productList1 = shipment.getProductList();

        for(int i=0; i<productList1.size(); i++){
            System.out.println("Product " + i+1 + "'s ID: " + productList1.get(i).getId());
            System.out.println("Product " + i+1 + "'s name: " + productList1.get(i).getName());
            System.out.println("Product " + i+1 + "'s stock count: " + productList1.get(i).getStockCount());
            System.out.println("Product " + i+1 + "'s category: " + productList1.get(i).getCategory());
        }

        System.out.println("Enter the ID of the branch you want to see the shipment history of");
        branchId = scan.nextInt();

        PriorityQueue<Product> shipmentHistory;
        shipmentHistory = branchEmployeeService.getShipmentHistory(branchId);

        for(int i=1; shipmentHistory.peek(); i++){
            System.out.println("Shipment " + i + "'s ID: " + shipmentHistory.poll().getId());
            System.out.println("Shipment " + i + "'s transportation employee's ID: " + shipmentHistory.poll().getEmployee());
            System.out.println("Shipment " + i + "'s shipment status: " + shipmentHistory.poll().getStatus());
            System.out.println("Shipment " + i + "'s product list: ");

            List<Product> productList2;
            productList2 = shipment.getProductList();

            for(int j=0; j<productList2.size(); j++){
                System.out.println("\tProduct " + j+1 + "'s ID: " + productList2.get(j).getId());
                System.out.println("\tProduct " + j+1 + "'s name: " + productList2.get(j).getName());
                System.out.println("\tProduct " + j+1 + "'s stock count: " + productList2.get(j).getStockCount());
                System.out.println("\tProduct " + j+1 + "'s category: " + productList2.get(j).getCategory());
            }
        }

        BinarySearchTree<Product> productList3 = new BinarySearchTree<Product>();

        Product product1 = new Product(branchEmployees[0].getBranchId(),"drink",50, drink);
        if(productList3.add(product1))  System.out.println("product1 is added to productList3 successfully");

        Product product2 = new Product(branchEmployees[1].getBranchId(),"fruit",100, fruit);
        if(productList3.add(product2))  System.out.println("product1 is added to productList3 successfully");

        Product product3 = new Product(branchEmployees[2].getBranchId(),"bread",150, bread);
        if(productList3.add(product3))  System.out.println("product1 is added to productList3 successfully");

        Product product4 = new Product(branchEmployees[3].getBranchId(),"water",200, water);
        if(productList3.add(product4))  System.out.println("product1 is added to productList3 successfully");

        Product product5 = new Product(branchEmployees[4].getBranchId(),"snack",250, snack);
        if(productList3.add(product5))  System.out.println("product1 is added to productList3 successfully");

        if(branchEmployeeService.createShipmentRequest(productList3))   System.out.println("Shipment requesting productList3 is created successfully");

        branchEmployeeService.createSupplyRequest(productList3);
        System.out.println("Supply request for productList3 is created successfully");
    
    */
    }
}
