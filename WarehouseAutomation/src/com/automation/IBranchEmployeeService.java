package com.automation;

import java.util.List;

public interface IBranchEmployeeService {
    boolean requestProduct();
    List<Product> getProductList();
    Product getProductById(int productId);
    List<Shipment> getProductRequestHistory();
    void createSupplyRequest(List<Product> productList);
}
