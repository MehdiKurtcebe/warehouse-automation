package com.automation;

public class BranchEmployee extends Employee {
    private int branchId;

    public BranchEmployee(String name, String phone, String email, String password, int branchId){
        super(name, phone, email, password);
        this.branchId = branchId;
    }

    public int getBranchId() {
        return branchId;
    }


    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
