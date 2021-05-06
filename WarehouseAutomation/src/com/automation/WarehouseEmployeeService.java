package com.automation;

import java.util.List;

public class WarehouseEmployeeService implements IWarehouseEmployeeService {
    private IWarehouseService warehouseService;

    public WarehouseEmployeeService(){
        this.warehouseService = new WarehouseService();
    }

    @Override
    public void updateShipmentStatus(Shipment shipment, ShipmentStatus shipmentStatus) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Shipment getShipmentInformation(int shipmentId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getProductList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product searchProduct(int productId) {
        throw new UnsupportedOperationException();
    }
}
