package com.automation;

import java.util.List;
import java.util.PriorityQueue;

public interface IWarehouseService {
    PriorityQueue<Shipment> getShipmentsByBranchId(int branchId);
    List<Product> getProductList();
    List<Product> getOutOfStockProducts();
    boolean supplyProduct(Product product, int branchId);
    boolean supplyProduct(List<Product> productList, int branchId);
    void updateShipmentStatus(int shipmentId, ShipmentStatus shipmentStatus);
    Shipment getShipmentById(int shipmentId);
    PriorityQueue<Shipment> getShipments();

    Product searchProductById(int productId);

    boolean addProduct(Product product);
    boolean removeProduct(int product);



    Shipment getShipmentToDeliver(int branchId);
}
