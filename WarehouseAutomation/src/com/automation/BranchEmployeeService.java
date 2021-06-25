package com.automation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class BranchEmployeeService implements IBranchEmployeeService {

    private IWarehouseService warehouseService;
    private IUserService userService;

    BranchEmployeeService(){
        warehouseService = new WarehouseService();
    }

    public void toString(int id){
        BranchEmployee branchEmployee = (BranchEmployee)userService.search(id);
        if(branchEmployee == null) throw new NoSuchElementException();
        System.out.println("Name: " + branchEmployee.getName());
        System.out.println("Phone: " + branchEmployee.getPhone());
        System.out.println("Email: " + branchEmployee.getEmail());
        System.out.println("Password: " + branchEmployee.getPassword());
        System.out.println("ID: " + branchEmployee.getId());
        System.out.println("Branch ID: " + branchEmployee.getBranchId());
    }

    public boolean createShipmentRequest(List<Product> productList) {
        if(productList.size() == 0) return false;
        return warehouseService.supplyProduct(productList, productList.get(0).getStoreId());
    }
    public boolean createShipmentRequest(List<Product> productList, int branchId) {
        return warehouseService.supplyProduct(productList, branchId);
    }

    @Override
    public BinarySearchTree<Product> getProductList(int branchId) {
        BinarySearchTree<Product> productList = new BinarySearchTree<>();
        for(Product p: warehouseService.getProductList()){
            if(p.getStoreId() == branchId) productList.add(p);
        }
        if(productList.size() == 0) throw new IllegalStateException();
        return productList;
    }

    @Override
    public Shipment getShipmentById(int shipmentId, int branchId) {
        for(Shipment s: warehouseService.getShipmentsByBranchId(branchId)){
            if(s.getId() == shipmentId) return s;
        }
        throw new NoSuchElementException();
    }

    @Override
    public Product getProductById(int productId) {
        for(Product p: warehouseService.getProductList()){
            if(p.getId() == productId) return p;
        }
        return new Product();
    }

    @Override
    public PriorityQueue<Shipment> getShipmentHistory(int branchId) {
        if(warehouseService.getShipmentsByBranchId(branchId).size() == 0)  throw new IllegalStateException();
        else return warehouseService.getShipmentsByBranchId(branchId);
    }

    @Override
    public void createSupplyRequest(List<Product> productList, int branchId) {
        warehouseService.supplyProduct(productList, branchId);
    }
}
