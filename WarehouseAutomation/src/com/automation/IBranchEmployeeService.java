package com.automation;

import java.util.PriorityQueue;

public interface IBranchEmployeeService {
    boolean createShipmentRequest(BinarySearchTree<Product> productList);
    BinarySearchTree<Product> getProductList(int branchId);
    Shipment getShipmentById(int shipmentId,int branchId);
    PriorityQueue<Shipment> getShipmentHistory(int branchId);
}
