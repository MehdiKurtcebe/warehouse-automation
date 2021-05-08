package com.automation;

import java.util.List;

public class WarehouseService implements IWarehouseService {

    private static Warehouse warehouse = new Warehouse();

    public WarehouseService(){

    }

    @Override // queue bir tane olmayacak mı?, warehouse içinde
    public PriorityQueue<Shipment> getShipmentsByBranchId(int branchId) {

        //filter shipments with given branch id and return it
        if(branchId<0 || warehouse.getshipments()==null )
        throw new UnsupportedOperationException();

        Iterator iterator = warehouse.getshipments().iterator();
        Shipment temp;
        for (Shipment tmp:warehouse.getshipments()) {
            if(branchId==tmp.getBranchId())
                temp=tmp;
        }


        return temp;
    }

    // hatalı çünkü warehouseda shipmentlar var , her birinde ayrı productlist var,bu isteniyorsa
    @Override
    public List<Product> getProductList() {

        if(warehouse.getshipments()==null)
        throw new UnsupportedOperationException();

        return warehouse.getstocks();


    }

    @Override//ne ile karşılaştırılıp bir liste oluşturulacak?
    public List<Product> getOutOfStockProducts() {

        throw new UnsupportedOperationException();
    }

    /**
     * Adds given product to supply list
     * @param product product to be added
     * @return true if it is succeed
     */
    @Override   // burda başka bir list oluşması gerekiyor, her product için ayrı list inefficient olabilir
                // yeni branch id mi generate edilecek ve transportation empl, shipment oluşturmak için
    public boolean supplyProduct(Product product) {
        //Create shipment for it with none status and add it to warehouse


        if(product==null)
        throw new UnsupportedOperationException();

        List<Product> productList=new ArrayList<>();

        productList.add(product);

        TransportationEmployee newtrans = new TransportationEmployee(name,  phone,  email,  password, branchId);
        //int shipid= generate


        Shipment ship = new Shipment();

    }

    @Override// üsttekiyle aynı şekilde shipment bilgileri gerekli,branch id ve temployee
    public boolean supplyProduct(List<Product> productList) {
        //Create shipments for it with none status and add it to warehouse
        if(productList==null)
        throw new UnsupportedOperationException();

        Shipment ship = new Shipment();
    }

    @Override
    // bu üstteki by branch id methodunun yerine olabilir
    public Shipment getShipmentToDeliver(int branchId) {
       //search shipment list by branchId and get random one
        if(branchId<0 || warehouse.getshipments()==null )
            throw new UnsupportedOperationException();


        Shipment temp;
        for (Shipment tmp:warehouse.getshipments()) {
            if(branchId==tmp.getBranchId())
                temp=tmp;
        }

        return temp;
    }
}
