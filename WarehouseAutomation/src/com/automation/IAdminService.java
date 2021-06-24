package com.automation;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public interface IAdminService {
    HashMap<Integer, Branch> getBranches();
    List<Branch> queryBranchesByName(String name);
    Branch queryBranchById(int id);
    boolean addBranch(Branch branch);
    boolean removeBranch(int branchId);
    boolean setEmployeeName(int employeeId, String name);
    boolean setEmployeePassword(int employeeId, String password);
    boolean addEmployee(Employee employee);
    boolean removeEmployee(Employee employee);
    ConcurrentSkipListMap<Integer, Employee> getEmployees();
    List<Employee> queryEmployeesByName(String name);
    Employee queryEmployeeById(int id);
    List<Employee> getWaitingApprovals();
    boolean addEmployeeToApproval(Employee employee);
    void approveEmployee(int employeeId);
    void rejectEmployee(int employeeId);
    ArrayList<Product> getProducts();
    List<Product> queryProductByName(String name);
    Product queryProductById(int id);
    boolean addProduct(Product product);
    boolean removeProduct(Product product);
    PriorityQueue<Shipment> getShipments();
}
