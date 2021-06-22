package com.automation;

import java.util.ArrayList;


public class BranchService implements IBranchService{
    private static ArrayList<Branch> branches = new ArrayList<>(); //TODO update with selected data structure

    @Override
    public boolean add(Branch branch){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int branchId){
        throw new UnsupportedOperationException();
    }

    @Override
    public Branch search(int branchId) {
        throw new UnsupportedOperationException();
    }


}
