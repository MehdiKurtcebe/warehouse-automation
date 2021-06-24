package com.automation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static com.automation.ShipmentStatus.NONE;

public class WarehouseService implements IWarehouseService {

    private static final Warehouse warehouse = new Warehouse();

    public WarehouseService(){

    }
    public void updateShipmentStatus(int shipmentId, ShipmentStatus shipmentStatus) {
        if(shipmentId<0 || warehouse.getShipments()==null || shipmentStatus==null )
            return;

        warehouse.updateShipmentStat(shipmentId,shipmentStatus);

    }
    public Shipment getShipmentById(int shipmentId){
        if(shipmentId<0 || warehouse.getShipments()==null )
            return null;

        for (Shipment shipment:warehouse.getShipments()) {
            if(shipmentId==shipment.getId())
                return shipment;
        }

        return null;
    }
    public  Product searchProductById(int productId){
        return warehouse.searchProduct(productId);
    }
    public boolean addProduct(Product product){
        return warehouse.addProd(product);
    }
    public boolean removeProduct(int productId){
        return  warehouse.removeProd(productId);
    }

    @Override
    public PriorityQueue<Shipment> getShipmentsByBranchId(int branchId) {


        //filter shipments with given branch id and return it
        if(branchId<0 || warehouse.getShipments()==null )
            return null;

        PriorityQueue<Shipment> shiplist= new PriorityQueue();
        Shipment ship;
        //Iterator iterator = warehouse.getshipments().iterator();

        for (Shipment ships : warehouse.getShipments()){

            if(branchId==ships.getBranchId()) {
                ship = ships;
                shiplist.add(ship);
            }
        }

    return shiplist;

    }



    @Override
    public List<Product> getProductList() {

        if(warehouse.getStocks()==null)
            return null;

        return warehouse.getStocks();


    }

    @Override
    public List<Product> getOutOfStockProducts() {
        return warehouse.findOutProducts();

    }
    /**
     * Adds given product to supply list
     * @param product product to be added
     * @return true if it is succeed
     */
    @Override
    public boolean supplyProduct(Product product) {
        //Create shipment for it with none status and add it to warehouse


        if(product==null)
          return false;
    //
        List<Product> productList=new ArrayList<>();

        productList.add(product);

        //near dan alıcaz

        //int shipid= generate


        Shipment ship = new Shipment(NONE,productList);

        return warehouse.addShipment(ship);
    }


  

    @Override
    // bu üstteki by branch id methodunun yerine olabilir
    public Shipment getShipmentToDeliver(int branchId) {
       //search shipment list by branchId with status none and get random one
        if(branchId<0 || warehouse.getShipments()==null )
            return null;


        Shipment shipment=null;
        for (Shipment tmp:warehouse.getShipments()) {
            if(branchId==tmp.getBranchId())
                shipment=tmp;
        }

        return shipment;
    }
	
	
	@Override
	public boolean supplyProduct(BinarySearchTree<Product> productList) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public PriorityQueue<Shipment> getShipments() {
        return warehouse.getShipments();
    }
}
