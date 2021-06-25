package com.automation;

public class TransportationEmployee extends Employee {

    private int branchId;
    private boolean occupied;
    private ShipmentStatus shipmentStatus;
    private double distanceToWareHouse;

    public TransportationEmployee(String name, String phone, String email, String password, int branchId, double distanceToWareHouse){
        super(name, phone, email, password);
        this.branchId = branchId;
        this.occupied = false;
        this.shipmentStatus = ShipmentStatus.NONE;
        this.setDistanceToWareHouse(distanceToWareHouse);
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

	public double getDistanceToWareHouse() {
		return distanceToWareHouse;
	}

	public void setDistanceToWareHouse(double distanceToWareHouse) {
		this.distanceToWareHouse = distanceToWareHouse;
	}
    
    

}
