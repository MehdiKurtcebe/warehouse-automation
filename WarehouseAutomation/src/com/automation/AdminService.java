package com.automation;

import java.util.LinkedList;
import java.util.List;

public class AdminService implements IAdminService {
    private IBranchService branchService;
    private IUserService userService;
    private static List<Employee> waitingForApproval = new LinkedList<>();

    public AdminService(){
        branchService = new BranchService();        //use for branch operations
        userService = new UserService();    //use to add employees after approval or other methods
    }

    @Override
    public boolean addBranch(Branch branch) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeBranch(int branchId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addBranchEmployee(BranchEmployee branchEmployee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeBranchEmployee(int employeeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addTransportationEmployee(TransportationEmployee transportationEmployee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeTransportationEmployee(int employeeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addWarehouseEmployee(WarehouseEmployee warehouseEmployee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeWarehouseEmployee(int employeeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Employee> getWaitingApprovals() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addEmployeeToApproval(Employee employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void approveEmployee(int employeeId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateShipmentStatus(Shipment shipment, ShipmentStatus shipmentStatus) {
        throw new UnsupportedOperationException();
    }
}
