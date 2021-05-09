package com.automation;

public class WarehouseEmployee extends Employee {
    private int warehouseId;

    public WarehouseEmployee(String name, String phone, String email, String password, int warehouseId){
        super(name, phone, email, password);
        this.warehouseId = warehouseId;
        this.warehouseId = IdGenerator.GetFreshWarehouseEmployeeId();
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

}
