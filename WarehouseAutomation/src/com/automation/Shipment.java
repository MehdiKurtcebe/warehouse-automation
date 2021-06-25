package com.automation;

import java.util.List;

public class Shipment {

    private int Id;
    private int branchId;
    private TransportationEmployee employee;
    private ShipmentStatus status;
    private List<Product> productList;

    public Shipment(int branchId, ShipmentStatus status, List<Product> productList) {
        //this.id = generate id
        this.branchId=branchId;
        TransportationEmployeeService serve=new TransportationEmployeeService();
        this.employee = serve.occupyNearEmployee();
        this.status = status;
        InsertionSort insertionSort;
        productList = insertionSort(productList);
        this.productList = productList;
        this.branchId = branchId;
    }
    public Shipment(ShipmentStatus status, List<Product> productList) {

        this.branchId=IdGenerator.GetFreshShipmentId();
        TransportationEmployeeService serve=new TransportationEmployeeService();
        this.employee = serve.occupyNearEmployee();
        this.status = status;
        this.productList = productList;

    }


    public int getId() {
        return Id;
    }

    public int getBranchId() {
        return branchId;
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

       //olan varsa üstüne mi eklenecek
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
