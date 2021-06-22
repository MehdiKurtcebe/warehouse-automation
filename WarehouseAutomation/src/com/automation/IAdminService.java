package com.automation;

import java.util.List;

public interface IAdminService {
    boolean addBranch(Branch branch);
    boolean removeBranch(int branchId);
    boolean addBranchEmployee(BranchEmployee branchEmployee);
    boolean removeBranchEmployee(int employeeId);
    boolean addTransportationEmployee(TransportationEmployee transportationEmployee);
    boolean removeTransportationEmployee(int employeeId);
    boolean addWarehouseEmployee(WarehouseEmployee warehouseEmployee);
    boolean removeWarehouseEmployee(int employeeId);
    List<Employee> getWaitingApprovals();
    boolean addEmployeeToApproval(Employee employee);
    void approveEmployee(int employeeId);
}
