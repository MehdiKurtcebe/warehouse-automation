package com.automation;

import java.util.List;

public interface IWarehouseService {
    List<Shipment> getShipmentsByBranchId(int branchId);
    List<Product> getProductList();
    List<Product> getOutOfStockProducts();
    boolean supplyProduct(Product product);
    boolean supplyProduct(List<Product> productList);
    Shipment getShipmentToDeliver(int branchId);
}
