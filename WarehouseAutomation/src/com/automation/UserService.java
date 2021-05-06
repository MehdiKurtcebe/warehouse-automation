package com.automation;

import java.util.LinkedList;
import java.util.List;

public class UserService implements IUserService {
    private static List<Employee> employeeList = new LinkedList<>();
    private IAdminService adminService;

    public UserService(){
        this.adminService = new AdminService();
    }

    @Override
    public boolean login(String email, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean signUp(String name, String phone, String email, String password, UserType userType) {
        //confirm user parameters
        //create employee with given userType
        //send it to admin approval
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addUser(Employee employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeUser(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
