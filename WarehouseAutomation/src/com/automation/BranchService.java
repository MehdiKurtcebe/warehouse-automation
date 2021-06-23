package com.automation;

import java.util.ArrayList;


public class BranchService implements IBranchService{
    private static ArrayList<Branch> branches = new ArrayList<>(); 

    @Override
    public boolean add(Branch branch){
    	if(branch == null) return false;
       return branches.add(branch);
    }

    @Override
    public boolean remove(int branchId){
        
        Branch branch = search(branchId);
        branches.remove(branch);
        return true;
    }

    @Override
    public Branch search(int branchId) {
    	Branch branch = new Branch();
        for(Branch b:  branches) {
        	if(b.getId() == branchId) {
        		branch = b;
        		break;
        	}
        }
        return branch;
    }


}
