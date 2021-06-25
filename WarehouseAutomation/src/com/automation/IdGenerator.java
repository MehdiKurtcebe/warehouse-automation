package com.automation;

import java.util.*;

public class IdGenerator {

    private static int idCounter = 1000;

    public static int GetFreshBranchEmployeeId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshBranchId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshAdminId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshWarehouseEmployeeId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshWarehouseId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshProductId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshTransportationEmployeeId(){
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public static int GetFreshShipmentId(){
        return idCounter++;
    }
}
