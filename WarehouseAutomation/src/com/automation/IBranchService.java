package com.automation;

import java.util.HashMap;

public interface IBranchService {
    boolean add(Branch branch);
    boolean remove(int branchId);
    Branch search(int branchId);
    HashMap<Integer, Branch> getBranches();
}
