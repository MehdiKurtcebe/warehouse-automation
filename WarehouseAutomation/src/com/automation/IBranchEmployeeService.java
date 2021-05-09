package com.automation;

import java.util.PriorityQueue;

public interface IBranchEmployeeService {
    boolean createShipmentRequest();
    BinarySearchTree<Product> getProductList();
    Shipment getShipmentById(int shipmentId);
    PriorityQueue<Shipment> getShipmentHistory();
    void createSupplyRequest(List<Product> productList);
}
