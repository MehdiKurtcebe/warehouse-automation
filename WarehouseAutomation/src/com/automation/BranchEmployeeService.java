package com.automation;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class BranchEmployeeService implements IBranchEmployeeService {

    private IWarehouseService warehouseService;

    BranchEmployeeService(){
        warehouseService = new WarehouseService();
    }

    public boolean createShipmentRequest(BinarySearchTree<Product> productList) {
        return warehouseService.supplyProduct(productList);
    }

    @Override
    public BinarySearchTree<Product> getProductList(int branchId) {
        BinarySearchTree<Product> productList = new BinarySearchTree<>();
        for(Product p: warehouseService.getProductList()){
            if(p.getStoreId() == branchId()) productList.add(p);
        }
        if(productList.size() == 0) throw new IllegalStateException();
        return productList;
    }

    @Override
    public Shipment getShipmentById(int shipmentId, int branchId) {
        for(Shipment s: warehouseService.getShipmentsByBranchId(branchId())){
            if(s.getId() == shipmentId) return s;
        }
        throw new NoSuchElementException();
    }

    @Override
    public PriorityQueue<Shipment> getShipmentHistory(int branchId) {
        if(warehouseService.getShipmentsByBranchId(branchId()).size == 0)  throw new IllegalStateException();
        else return warehouseService.getShipmentsByBranchId(branchId());
    }

    @Override
    public void createSupplyRequest(BinarySearchTree<Product> productList) {
        warehouseService.supplyProduct(productList);
    }
}
