package com.automation;

public abstract class Employee {
    private int id;     //TODO generate with id generator
    private String name;
    private String phone;
    private String email;
    private String password;
    private EmployeeStatus status;

    public Employee(){
        if (this instanceof BranchEmployee) id = IdGenerator.GetFreshBranchEmployeeId();
        else if (this instanceof Admin) id = IdGenerator.GetFreshAdminId();
        else if (this instanceof WarehouseEmployee) id = IdGenerator.GetFreshWarehouseEmployeeId();
        else if (this instanceof TransportationEmployee) id = IdGenerator.GetFreshTransportationEmployeeId();

        status = EmployeeStatus.WAITING_FOR_APPROVAL;
    }

    public Employee(String name, String phone, String email, String password){
        if (this instanceof BranchEmployee) id = IdGenerator.GetFreshBranchEmployeeId();
        else if (this instanceof Admin) id = IdGenerator.GetFreshAdminId();
        else if (this instanceof WarehouseEmployee) id = IdGenerator.GetFreshWarehouseEmployeeId();
        else if (this instanceof TransportationEmployee) id = IdGenerator.GetFreshTransportationEmployeeId();

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        status = EmployeeStatus.WAITING_FOR_APPROVAL;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
