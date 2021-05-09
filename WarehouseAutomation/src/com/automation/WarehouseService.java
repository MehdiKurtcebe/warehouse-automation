package com.automation;

import java.util.ArrayList;
import java.util.List;

public class WarehouseService implements IWarehouseService {

    private static final Warehouse warehouse = new Warehouse();

    public WarehouseService(){

    }
    public void updateShipmentStatus(int shipmentId, ShipmentStatus shipmentStatus) {
        throw new UnsupportedOperationException();
    }
    public Shipment getShipmentById(int shipmentId){
        throw new UnsupportedOperationException();
    }
    public  Product searchProductById(int productId){
        throw new UnsupportedOperationException();
    }
    public boolean addProduct(Product product){
        throw new UnsupportedOperationException();
    }
    public boolean removeProduct(int productId){
        throw new UnsupportedOperationException();
    }

    @Override // queue bir tane olmayacak mı?, warehouse içinde, traverse gerekli
    public List<Shipment> getShipmentsByBranchId(int branchId) {

        //filter shipments with given branch id and return it
        if(branchId<0 || warehouse.getShipments()==null )
            throw new UnsupportedOperationException();

        Shipment ship=null;
        //Iterator iterator = warehouse.getshipments().iterator();

        for (Shipment ships : warehouse.getShipments()){

            if(branchId==ships.getBranchId())
                ship=ships;
        }


        throw new UnsupportedOperationException();
    }




    // hatali olabilir çünkü warehouseda shipmentlar var , her birinde ayrı productlist var,bu isteniyorsa
    @Override
    public List<Product> getProductList() {

        if(warehouse.getStocks()==null)
            throw new UnsupportedOperationException();

        return warehouse.getStocks();


    }

    @Override//başka bir list ile karşılaştırılıp bir liste oluşturulacak? ,
    // yoksa stocksdaki productların stock countuna mı bakılacak
    // <0 ı kontrol
    public List<Product> getOutOfStockProducts() {

        throw new UnsupportedOperationException();
    }

    /**
     * Adds given product to supply list
     * @param product product to be added
     * @return true if it is succeed
     */
    @Override   // burada başka bir list oluşması gerekiyor, her product için ayrı list inefficient olabilir
                // yeni branch id mi generate edilecek ve transportation empl, shipment oluşturmak için
    public boolean supplyProduct(Product product) {
        //Create shipment for it with none status and add it to warehouse


        if(product==null)
        throw new UnsupportedOperationException();
    //
        List<Product> productList=new ArrayList<>();

        productList.add(product);

        //near dan alıcaz

        //int shipid= generate


        Shipment ship = new Shipment(ShipmentStatus.NONE,productList);

        throw new UnsupportedOperationException();
    }

    @Override// üsttekiyle aynı şekilde shipment bilgileri gerekli,branch id ve temployee
    public boolean supplyProduct(List<Product> productList) {
        //Create shipments for it with none status and add it to warehouse
        if(productList==null)
        throw new UnsupportedOperationException();

        //Shipment ship = new Shipment();

        throw new UnsupportedOperationException();
    }

    @Override
    // bu üstteki by branch id methodunun yerine olabilir
    public Shipment getShipmentToDeliver(int branchId) {
       //search shipment list by branchId with status none and get random one
        if(branchId<0 || warehouse.getShipments()==null )
            throw new UnsupportedOperationException();


        Shipment temp=null;
        for (Shipment tmp:warehouse.getShipments()) {
            if(branchId==tmp.getBranchId())
                temp=tmp;
        }

        return temp;
    }
}
