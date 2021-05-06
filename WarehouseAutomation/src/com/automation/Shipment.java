package com.automation;

import java.util.List;

public class Shipment {

    private int Id;
    private int branchId;
    private TransportationEmployee employee;
    private ShipmentStatus status;
    private List<Product> productList;

    public Shipment(int branchId, TransportationEmployee employee, ShipmentStatus status, List<Product> productList) {
        //this.id = generate id
        this.employee = employee;
        this.status = status;
        this.productList = productList;
        this.branchId = branchId;
    }

    public Shipment(int branchId, TransportationEmployee employee, List<Product> productList) {
        //this.id = generate id
        this.status = ShipmentStatus.NONE;
        this.employee = employee;
        this.productList = productList;
        this.branchId = branchId;
    }

    public int getId() {
        return Id;
    }


    public TransportationEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(TransportationEmployee employee) {
        this.employee = employee;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
