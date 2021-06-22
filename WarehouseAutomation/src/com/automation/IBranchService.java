package com.automation;

public interface IBranchService {
    boolean add(Branch branch);
    boolean remove(int branchId);
    Branch search(int branchId);
}
