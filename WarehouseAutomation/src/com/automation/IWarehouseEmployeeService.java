package com.automation;

import java.util.List;

public interface IWarehouseEmployeeService {
    void updateShipmentStatus(Shipment shipment, ShipmentStatus shipmentStatus);
    Shipment getShipmentInformation(int shipmentId);
    List<Product> getProductList();
    Product searchProduct(int productId);
}
