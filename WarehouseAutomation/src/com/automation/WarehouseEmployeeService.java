package com.automation;
import java.util.List;

public class WarehouseEmployeeService implements IWarehouseEmployeeService {
    private IWarehouseService warehouseService;

    public WarehouseEmployeeService(){
        this.warehouseService = new WarehouseService();
    }

    @Override
    public void updateShipmentStatus(int shipmentId, ShipmentStatus shipmentStatus) {
        warehouseService.updateShipmentStatus(shipmentId, shipmentStatus);
    }

    @Override
    public Shipment getShipmentInformation(int shipmentId) {
        return warehouseService.getShipmentById(shipmentId);
    }

    @Override
    public BinarySearchTree<Product> getProductList() {
        return warehouseService.getProductList();
    }

    @Override
    public Product searchProduct(int productId) {
        return warehouseService.searchProductById(productId);
    }

    @Override
    public boolean addProduct(Product product) {
        if(product == null) throw new UnsupportedOperationException();
        return warehouseService.addProduct(product);
    }

    @Override
    public boolean removeProduct(int productId) {
        return warehouseService.removeProduct(productId);
    }
}
