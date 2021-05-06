package com.automation;

import java.util.LinkedList;
import java.util.List;

public class Warehouse {
    private static List<Shipment> shipments = new LinkedList<>();
    private static List<Product> stocks = new LinkedList<>();
    private int id;
    private String address;
    private String phone;

    public Warehouse(){
       // this.id = (new IdGenerator()).Generate();
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        Warehouse.shipments = shipments;
    }

    public static List<Product> getStocks() {
        return stocks;
    }

    public static void setStocks(List<Product> stocks) {
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
