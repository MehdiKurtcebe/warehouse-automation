package com.automation;

import java.util.List;

public interface ITransportationEmployeeService {

    TransportationEmployee occupyNearEmployee();		
    boolean releaseGivenEmployee(int transportationEmployeeId);
    void updateShipmentStatus(int shipmentId, ShipmentStatus status);
    Shipment getShipmentToBeDelivered(int branchId);
}
