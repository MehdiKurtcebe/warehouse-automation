package com.automation;

import java.util.PriorityQueue;

public class BranchEmployeeService implements IBranchEmployeeService {

    private IWarehouseService warehouseService;

    BranchEmployeeService(){
        this.warehouseService = new WarehouseService();
    }

    @Override
    public boolean createShipmentRequest(BinarySearchTree<Product> productList) {
        return warehouseService.supplyProduct(productList);
    }

    @Override
    public BinarySearchTree<Product> getProductList() {
        BinarySearchTree<Product> productList = new BinarySearchTree<>();
        for(Product p: warehouseService.getProductList()){
            if(p.getStoreId() == getBranchId()) productList.add(p);
        }
        if(productList.size() == 0) throw new IllegalStateException();
        return productList;
    }

    @Override
    public Shipment getShipmentById(int shipmentId) {
        for(Shipment s: warehouseService.getShipmentsByBranchId(getBranchId())){
            if(s.getId() == shipmentId) return s;
        }
        throw new NoSuchElementException();
    }

    @Override
    public PriorityQueue<Shipment> getShipmentHistory() {
        if(warehouseService.getShipmentsByBranchId(getBranchId()).size == 0)  throw new IllegalStateException();
        else return warehouseService.getShipmentsByBranchId(getBranchId());
    }

    @Override
    public void createSupplyRequest(BinarySearchTree<Product> productList) {
        warehouseService.supplyProduct(productList);
    }
}
