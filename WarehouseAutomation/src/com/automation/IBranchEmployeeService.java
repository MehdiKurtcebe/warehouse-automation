package com.automation;

import java.util.PriorityQueue;

public interface IBranchEmployeeService {
    boolean createShipmentRequest(BinarySearchTree<Product> productList);
    BinarySearchTree<Product> getProductList(int branchId);
    Shipment getShipmentById(int shipmentId,int branchId);
    Product getProductById(int productId);
    PriorityQueue<Shipment> getShipmentHistory(int branchId);
    void createSupplyRequest(BinarySearchTree<Product> productList);
    public void toString(int id);
}
