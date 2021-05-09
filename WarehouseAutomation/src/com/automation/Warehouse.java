package com.automation;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Warehouse {
    private static PriorityQueue<Shipment> shipments = new PriorityQueue<>();
    private static BinarySearchTree<Product> stocks = new BinarySearchTree<>();
    private final int id;
    private String address;
    private String phone;

    public Warehouse(){
       this.id = IdGenerator.GetFreshWarehouseId();

        address="Default Address";
        phone="444 44 44";
    }
    public Warehouse( String address,String phone){
        this.id = IdGenerator.GetFreshWarehouseId();
        this.address=address;
        this.phone=phone;
    }
    public Warehouse(int id , String address,String phone){

        this.id = id;
        this.address=address;
        this.phone=phone;
    }


    //
    //

    public PriorityQueue<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(PriorityQueue<Shipment> shipments) {
        Warehouse.shipments = shipments;
    }

    public static BinarySearchTree<Product> getStocks() {
        return stocks;
    }

    public static void setStocks(BinarySearchTree<Product> stocks) {
        Warehouse.stocks = stocks;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
