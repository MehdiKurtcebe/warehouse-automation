package com.automation;

import java.util.List;

public interface IWarehouseService {
    List<Shipment> getShipmentsByBranchId(int branchId);
    List<Product> getProductList();
    List<Product> getOutOfStockProducts();
    boolean supplyProduct(Product product);
    boolean supplyProduct(List<Product> productList);
    void updateShipmentStatus(int shipmentId, ShipmentStatus shipmentStatus);
    Shipment getShipmentById(int shipmentId);

    Product searchProductById(int productId);

    boolean addProduct(Product product);
    boolean removeProduct(int product);



    Shipment getShipmentToDeliver(int branchId);
}
