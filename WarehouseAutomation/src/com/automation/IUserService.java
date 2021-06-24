package com.automation;

import java.util.concurrent.ConcurrentSkipListMap;

public interface IUserService {
	Employee login(String email, String password);
    boolean signUp(String name, String phone, String email, String password, UserType userType);
    boolean addUser(Employee employee);
    boolean removeUser(Employee employee);
    boolean setUserName(int id, String name);
    boolean setUserPassword(int id, String password);
    Employee search(int id);
    ConcurrentSkipListMap<Integer, Employee> getEmployees();
}
