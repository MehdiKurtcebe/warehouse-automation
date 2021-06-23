package com.automation;

import java.util.List;

public interface IWarehouseEmployeeService {
    void updateShipmentStatus(int shipmentId, ShipmentStatus shipmentStatus);
    Shipment getShipmentInformation(int shipmentId);
    List<Product> getProductList();
    Product searchProduct(int productId);
    boolean addProduct(Product product);
    boolean removeProduct(int productId);
}
