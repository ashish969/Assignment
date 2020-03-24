package com.assignment.inventory.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.assignment.inventory.bean.InventoryManagement;
@Repository
public class InventoryManagementDAO {

	static public Map<Integer, InventoryManagement> mapOfProducts = new LinkedHashMap<Integer, InventoryManagement>();
	static int count=10008;
	static
	{
		mapOfProducts.put(10001, new InventoryManagement("shirt",10001,500.0,5));
		mapOfProducts.put(10002, new InventoryManagement("jeans",10002,699.6,12));
		mapOfProducts.put(10003, new InventoryManagement("wifi",10003,1550.6,7));
		mapOfProducts.put(10004, new InventoryManagement("rice",10003,100.6,7));
		mapOfProducts.put(10005, new InventoryManagement("pen",10003,10.6,7));
		mapOfProducts.put(10006, new InventoryManagement("phone",10003,15050.6,7));
		mapOfProducts.put(10007, new InventoryManagement("Tv",10003,14500.6,7));
		mapOfProducts.put(10008, new InventoryManagement("washingMachine",10003,15500.6,7));
	}
	
	public Collection<InventoryManagement> getAllProduct(){
		return mapOfProducts.values();			
	}
	
	public InventoryManagement getProductDetailsById(int id){
		return mapOfProducts.get(id);
	}
	
	public InventoryManagement addProduct(InventoryManagement inventoryManagement){
		mapOfProducts.put(inventoryManagement.getProductId(), inventoryManagement);
		return inventoryManagement;
	}
	
	public InventoryManagement updateProduct (InventoryManagement inventoryManagement){
		mapOfProducts.put(inventoryManagement.getProductId(), inventoryManagement);
		return inventoryManagement;
	}
	
	public InventoryManagement removeProduct (int id){
		InventoryManagement inventoryManagement= mapOfProducts.remove(id);
		return inventoryManagement;
	}
}
