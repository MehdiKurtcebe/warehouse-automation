package com.automation;

import java.util.List;

public class WarehouseService implements IWarehouseService {

    private static Warehouse warehouse = new Warehouse();

    public WarehouseService(){

    }

    @Override
    public List<Shipment> getShipmentsByBranchId(int branchId) {
        //filter shipments with given branch id and return it
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getProductList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getOutOfStockProducts() {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds given product to supply list
     * @param product product to be added
     * @return true if it is succeed
     */
    @Override
    public boolean supplyProduct(Product product) {
        //Create shipment for it with none status and add it to warehouse
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean supplyProduct(List<Product> productList) {
        //Create shipments for it with none status and add it to warehouse
        throw new UnsupportedOperationException();
    }

    @Override
    public Shipment getShipmentToDeliver(int branchId) {
       //search shipment list by branchId and get random one
        throw  new UnsupportedOperationException();
    }
}
