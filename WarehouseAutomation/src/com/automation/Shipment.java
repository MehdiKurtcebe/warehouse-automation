package com.automation;

import java.util.List;

public class Shipment implements Comparable<Shipment> {

    private int Id;
    private int branchId;
    private TransportationEmployee employee;
    private ShipmentStatus status;
    private List<Product> productList;

    public Shipment(int branchId, ShipmentStatus status, List<Product> productList) {
        this.Id = IdGenerator.GetFreshShipmentId();
        TransportationEmployeeService serve=new TransportationEmployeeService();
        this.employee = serve.occupyNearEmployee();
        this.status = status;
        InsertionSort.sort(productList);
        this.productList = productList;
        this.branchId = branchId;
    }
    /*public Shipment(ShipmentStatus status, List<Product> productList) {

        this.branchId=IdGenerator.GetFreshShipmentId();
        TransportationEmployeeService serve=new TransportationEmployeeService();
        this.employee = serve.occupyNearEmployee();
        this.status = status;
        this.productList = productList;

    }*/


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

    @Override
    public int compareTo(Shipment o) {
        return this.getId() - o.getId();
    }
    
    @Override
    public String toString() {
    	return "Id " + Id + " transportationEmployeeId " + getEmployee().getId()+ " Products: " + getProductList() + " Branch Id " + getBranchId() ;
    }
}
