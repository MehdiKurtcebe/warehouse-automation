package com.automation;

import java.util.List;
import java.util.PriorityQueue;

public interface IBranchEmployeeService {
    boolean createShipmentRequest(List<Product> productList, int branchId);
    BinarySearchTree<Product> getProductList(int branchId);
    Shipment getShipmentById(int shipmentId,int branchId);
    PriorityQueue<Shipment> getShipmentHistory(int branchId);
    void createSupplyRequest(List<Product> productList, int branchId);
}
