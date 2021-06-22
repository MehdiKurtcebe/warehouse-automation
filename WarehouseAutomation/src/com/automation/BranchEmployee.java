package com.automation;

public class BranchEmployee extends Employee{
    private int branchId;
    private BranchService branchService = new BranchService();
    private UserService userService = new UserService();

    public BranchEmployee(){
        super();
    }

    public BranchEmployee(String name, String phone, String email, String password, int branchId){
        super(name, phone, email, password);
        try{
            if(branchService.search(branchId) == null){
                userService.removeUser(this);
                throw new Exception("There is no branch with branch ID");
            }
            this.branchId = branchId;
        }catch(Exception e){ System.out.println(e);}
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
