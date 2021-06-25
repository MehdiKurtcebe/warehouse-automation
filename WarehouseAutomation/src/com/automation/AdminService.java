package com.automation;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class AdminService implements IAdminService {
    private IBranchService branchService;
    private IUserService userService;
    private IProductService productService;
    private IWarehouseService warehouseService;
    private static List<Employee> waitingForApproval = new LinkedList<>();

    public AdminService(){
        branchService = new BranchService();        //use for branch operations
        userService = new UserService();    //use to add employees after approval or other methods
        productService = new ProductService();
        warehouseService = new WarehouseService();
    }

    @Override
    public HashMap<Integer, Branch> getBranches() {
        return branchService.getBranches();
    }

    @Override
    public List<Branch> queryBranchesByName(String name) {
        HashMap<Integer, Branch> branches = branchService.getBranches();
        ArrayList<Branch> searchResults = new ArrayList<>();

        for(Branch branch : branches.values()) {
            if (branch.getName().contains(name)) {
                searchResults.add(branch);
            }
        }

        return searchResults;
    }

    @Override
    public Branch queryBranchById(int id) {
        return branchService.search(id);
    }

    @Override
    public boolean addBranch(Branch branch) {
        return branchService.add(branch);
    }

    @Override
    public boolean removeBranch(int branchId) {
        return branchService.remove(branchId);
    }

    @Override
    public boolean setEmployeeName(int employeeId, String name) {
        return userService.setUserName(employeeId, name);
    }

    @Override
    public boolean setEmployeePassword(int employeeId, String password) {
        return userService.setUserPassword(employeeId, password);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        employee.setStatus(EmployeeStatus.APPROVED);
        return userService.addUser(employee);
    }

    @Override
    public boolean removeEmployee(int employeeId) {
        Employee employee = userService.search(employeeId);
        if (employee != null) return userService.removeUser(employee);
        else return false;
    }

    @Override
    public ConcurrentSkipListMap<Integer, Employee> getEmployees() {
        return userService.getEmployees();
    }

    @Override
    public LinkedList<Employee> queryEmployeesByName(String name) {
        ConcurrentSkipListMap<Integer, Employee> employees = userService.getEmployees();
        LinkedList<Employee> searchResults = new LinkedList<>();

        for(Employee employee : employees.values()) {
            if (employee.getName().contains(name)) {
                searchResults.add(employee);
            }
        }

        return searchResults;
    }

    @Override
    public Employee queryEmployeeById(int id) {
        return userService.search(id);
    }

    @Override
    public List<Employee> getWaitingApprovals() {
        return waitingForApproval;
    }

    @Override
    public boolean addEmployeeToApproval(Employee employee) {
        employee.setStatus(EmployeeStatus.WAITING_FOR_APPROVAL);
        return waitingForApproval.add(employee);
    }

    @Override
    public void approveEmployee(int employeeId) {
        for(Employee employee : waitingForApproval) {
            if(employeeId == employee.getId()) {
                addEmployee(employee);
                waitingForApproval.remove(employee);
                break;
            }
        }
    }

    @Override
    public void rejectEmployee(int employeeId) {
        for(Employee employee : waitingForApproval) {
            if(employeeId == employee.getId()) {
                waitingForApproval.remove(employee);
                break;
            }
        }
    }

    @Override
    public ArrayList<Product> getProducts() {
        return productService.getProducts();
    }

    @Override
    public List<Product> queryProductByName(String name) {
        ArrayList<Product> products = productService.getProducts();
        ArrayList<Product> searchResults = new ArrayList<>();

        for(Product product : products) {
            if (product.getName().contains(name)) {
                searchResults.add(product);
            }
        }

        return searchResults;
    }

    @Override
    public Product queryProductById(int id) {
        return productService.search(id);
    }

    @Override
    public boolean addProduct(Product product) {
        return productService.add(product);
    }

    @Override
    public boolean removeProduct(int productId) {
        return productService.remove(productId);
    }

    @Override
    public PriorityQueue<Shipment> getShipments() {
        return warehouseService.getShipments();
    }
}
