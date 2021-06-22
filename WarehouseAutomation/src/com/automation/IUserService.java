package com.automation;

public interface IUserService {
    Employee login(String email, String password);
    boolean signUp(String name, String phone, String email, String password, UserType userType);
    boolean addUser(Employee employee);
    boolean removeUser(Employee employee);
}
