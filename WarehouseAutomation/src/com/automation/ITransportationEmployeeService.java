package com.automation;

import java.util.List;

public interface ITransportationEmployeeService {

    TransportationEmployee occupyNearEmployee(int branchId);
    boolean releaseGivenEmployee(int transportationEmployeeId);
    void updateShipmentStatus(ShipmentStatus status);
    Shipment getShipmentToBeDelivered(int branchId);
}
