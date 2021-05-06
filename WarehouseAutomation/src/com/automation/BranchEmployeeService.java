package com.automation;

import java.util.List;

public class BranchEmployeeService implements IBranchEmployeeService {

    private IWarehouseService warehouseService;

    BranchEmployeeService(){
        this.warehouseService = new WarehouseService();
    }

    @Override
    public boolean requestProduct() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getProductList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product getProductById(int productId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Shipment> getProductRequestHistory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createSupplyRequest(List<Product> productList) {
        warehouseService.supplyProduct(productList);
    }
}
