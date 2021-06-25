package com.automation;

import java.util.HashMap;
import java.util.Map.Entry;

public class TransportationEmployeeService implements  ITransportationEmployeeService {

    private IWarehouseService warehouseService;
    private IUserService userService;
    private Graph transportortationGraph;
    
    public TransportationEmployeeService(){
        warehouseService = new WarehouseService();
        userService = new UserService();
    }

    @Override
    public TransportationEmployee occupyNearEmployee() {				
    	HashMap<Integer, TransportationEmployee> graphValues = getAvailableTransportationEmployees(); 
    	int transportationEmpSize = graphValues.size();
        transportortationGraph = new ListGraph(transportationEmpSize+1, false);
        
        for(Entry<Integer, TransportationEmployee> emp: graphValues.entrySet()) {
        	Edge edge = new Edge(0, emp.getKey(),emp.getValue().getDistanceToWareHouse());
        	transportortationGraph.insert(edge);
        }
        
        int[] pred = new int[transportationEmpSize+1];
        double[] distances = new double[transportationEmpSize+1];
        
        DijkstrasAlgorithm.dijkstrasAlgorithm(transportortationGraph, transportationEmpSize, pred, distances);
        int min = 0;
        
        for(int i=0; i<distances.length; i++){
        	if(distances[i] < min)
        		min = i;
        }
        
        if(min == 0)
        	return null;
        
        else
        	return graphValues.get(min);
        
    }

    @Override
    public boolean releaseGivenEmployee(int transportationEmployeeId) {
        TransportationEmployee emp = (TransportationEmployee)userService.search(transportationEmployeeId);
        emp.setOccupied(false);
        return true;
    }

    @Override
    public void updateShipmentStatus(int shipmentId, ShipmentStatus status) {			
        warehouseService.updateShipmentStatus(shipmentId, status);
    }

    @Override
    public Shipment getShipmentToBeDelivered(int branchId) {		
        return warehouseService.getShipmentToDeliver(branchId);
    }

	
	private HashMap<Integer, TransportationEmployee> getAvailableTransportationEmployees() {
		HashMap<Integer, TransportationEmployee> transportationEmployees = new HashMap();
		
		int i=0;
		for(Employee emp: userService.getEmployees().values() ){
			if(emp instanceof TransportationEmployee && ! ((TransportationEmployee) emp).isOccupied() )
				{
					i++;
					transportationEmployees.put(i,(TransportationEmployee)emp);
				}
		}
		
		return transportationEmployees;
	}
	
    


}
