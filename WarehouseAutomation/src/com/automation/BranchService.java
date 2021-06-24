package com.automation;

import java.util.ArrayList;
import java.util.HashMap;


public class BranchService implements IBranchService{
    private static HashMap<Integer,Branch> branches = new HashMap<>(); 

    @Override
    public boolean add(Branch branch){
    	if(branch == null) return false;
    	if(branches.containsKey(branch.getId()))
    		return false;
       branches.put(branch.getId(),branch);
       return true;
    }

    @Override
    public boolean remove(int branchId){
    	return branches.remove(branchId) != null;
    }

    @Override
    public Branch search(int branchId) {
        return branches.get(branchId);
    }

    @Override
    public HashMap<Integer, Branch> getBranches() {
        return branches;
    }
}
