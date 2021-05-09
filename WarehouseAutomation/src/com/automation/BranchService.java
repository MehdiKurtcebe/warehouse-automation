package com.automation;

import java.util.LinkedList;
import java.util.List;

public class BranchService implements IBranchService{
    private static List<Branch> branchess = new LinkedList<>(); //TODO update with selected data structure

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
