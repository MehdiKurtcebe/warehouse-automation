package com.automation;

public class TransportationEmployeeService implements  ITransportationEmployeeService {

    private IWarehouseService warehouseService;

    public TransportationEmployeeService(){
        warehouseService = new WarehouseService();
    }

    @Override
    public TransportationEmployee occupyNearEmployee(int branchId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean releaseGivenEmployee(int transportationEmployeeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateShipmentStatus(ShipmentStatus status) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Shipment getShipmentToBeDelivered(int branchId) {
        throw new UnsupportedOperationException();
    }


}
