package com.automation;

public class TransportationEmployee extends Employee {

    private int branchId;
    private boolean occupied;
    private ShipmentStatus status;
    private double distanceToWareHouse;

    public TransportationEmployee(String name, String phone, String email, String password, int branchId, double distanceToWareHouse){
        super(name, phone, email, password);
        this.branchId = branchId;
        this.occupied = false;					
        this.status = ShipmentStatus.NONE;
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

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

	public double getDistanceToWareHouse() {
		return distanceToWareHouse;
	}

	public void setDistanceToWareHouse(double distanceToWareHouse) {
		this.distanceToWareHouse = distanceToWareHouse;
	}
    
    

}
