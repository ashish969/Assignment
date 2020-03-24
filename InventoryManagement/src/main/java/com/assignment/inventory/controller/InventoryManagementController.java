package com.assignment.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.assignment.inventory.bean.InventoryManagement;
import com.assignment.inventory.dao.InventoryManagementDAO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Inventory Management Service")
public class InventoryManagementController {

	@Autowired
	private InventoryManagementDAO daoClass;
	
	@RequestMapping(value = "product/controller/viewDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Make a GET call to fetch all product from Inventory", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The GET call is successfull"),
            @ApiResponse(code = 500, message = "The GET call is failed"),
            @ApiResponse(code = 404, message = "The GET call or product from inventory to be fetched could not be found") })
	public ResponseEntity<List<InventoryManagement>> getProductDetails() {
		List<InventoryManagement> listProduct = new ArrayList<InventoryManagement>(daoClass.getAllProduct());
		
		return new ResponseEntity<List<InventoryManagement>>(listProduct,HttpStatus.OK);
	}

	@RequestMapping(value = "product/controller/viewDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Make a GET call to fetch all product from Inventory", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The GET call is successfull"),
            @ApiResponse(code = 500, message = "The GET call is failed"),
            @ApiResponse(code = 404, message = "The GET call or product from inventory to be fetched could not be found") })
	public ResponseEntity<InventoryManagement> getProductDetailByProductId(
			@PathVariable("id") Integer id) {
		InventoryManagement inventoryManagement = daoClass.getProductDetailsById(id);

		if (inventoryManagement != null) {
			return new ResponseEntity<InventoryManagement>(inventoryManagement, HttpStatus.OK);
		} else {
			return new ResponseEntity<InventoryManagement>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/product/controller/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Make a POST call to create a product ", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The POST call is successfull"),
            @ApiResponse(code = 500, message = "The POST call is failed"),
            @ApiResponse(code = 404, message = "The API could not be found") })
	public ResponseEntity<InventoryManagement> addProduct(@RequestBody InventoryManagement inventoryManagement) {
		InventoryManagement added=daoClass.addProduct(inventoryManagement);
		
		return new ResponseEntity<InventoryManagement>(added,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/product/controller/updateProduct", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Make a POST call to update a product ", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The POST call is successfull"),
            @ApiResponse(code = 500, message = "The POST call is failed"),
            @ApiResponse(code = 404, message = "The API could not be found") })
	public ResponseEntity<InventoryManagement> updateProduct(@RequestBody  InventoryManagement inventoryManagement) {
		System.out.println(">>>"+inventoryManagement);
		if (daoClass.getProductDetailsById(inventoryManagement.getProductId()) == null) {
			InventoryManagement product2 = null;
			return new ResponseEntity<InventoryManagement>(product2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		InventoryManagement updated = daoClass.updateProduct(inventoryManagement);
		return new ResponseEntity<InventoryManagement>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/controller/deleteProduct/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Make a DELETE call to delete an product", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The DELETE call is successfull"),
            @ApiResponse(code = 500, message = "The DELETE call is failed"),
            @ApiResponse(code = 404, message = "The API or product to be deleted could not be found") })
	public ResponseEntity<InventoryManagement> deleteEmployee(
			@PathVariable("id") int myId) {
		if (daoClass.getProductDetailsById(myId) == null) {
			InventoryManagement product1 = null;
			return new ResponseEntity<InventoryManagement>(product1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		InventoryManagement product = daoClass.removeProduct(myId);
		return new ResponseEntity<InventoryManagement>(product, HttpStatus.OK);
	}
}
