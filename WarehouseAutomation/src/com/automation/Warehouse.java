package com.automation;

import java.util.ArrayList;
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
/**
 * add product
 * */
    public boolean addProd(Product product){
       return stocks.add(product);
    }
    public boolean removeProd(int productId){
        return stocks.remove(productId)!=null;
    }
    public boolean addShipment(Shipment newship){
        return shipments.add(newship);
    }
    /*
    public Shipment getShipment(int shipmentId){
        return null;
    }
    */
    public PriorityQueue<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(PriorityQueue<Shipment> shipments) {
        Warehouse.shipments = shipments;
    }


    public void updateShipmentStat(int shipmentId, ShipmentStatus shipmentStatus) {

        for (Shipment shipment : shipments) {
            if (shipmentId == shipment.getId())
                shipment.setStatus(shipmentStatus);
        }
    }


    public static List<Product> getStocks() {
        return stocks;
    }
    public  Product searchProduct(int productId){
        for (Product stock : stocks) {
            if (stock.getId() == productId)
                return stock;
        }
        return null;
    }
    public  List<Product> findOutProducts(){
        ArrayList<Product> outlist= new ArrayList<>();
        for (Product stock : stocks) {
            if (stock.getStockCount() < 1)
                outlist.add(stock);
        }
        return outlist;
    }
    public void setStocks(List<Product> stocks) {

     Warehouse.stocks = stocks;
    }   
      =======
    public static BinarySearchTree<Product> getStocks() {
        return stocks;
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
