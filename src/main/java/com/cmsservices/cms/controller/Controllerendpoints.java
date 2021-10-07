package com.cmsservices.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmsservices.cms.cmsentity.Customermodel;
import com.cmsservices.cms.cmsservices.CustomerServices;


@RestController
@RequestMapping(value = "/customerapis" , produces = "application/json")
public class Controllerendpoints {
	
	  @Autowired
	  public CustomerServices customerservice ;
	  
	
	  @PostMapping(value = "/addcustomer")
	  public Customermodel addcustomer(@RequestBody Customermodel customer) {
	        return customerservice.addCustomer(customer);
	    }

	  @GetMapping("/getcustomers")
	    public List<Customermodel> getcustomers() {
		    List<Customermodel> customers = customerservice.getCustomers();
		    // returns the list of customers stored in hiberanate db 
		    return customers;
	    }
	  
	  
	  @PutMapping("/updatecustomer/{id}")
	  public ResponseEntity<HttpStatus> modifycustomer( @PathVariable("id") long id , @RequestBody Customermodel customermodel ) {
		  // api to update the details of particulat customer specified by id 
		
			if (customerservice.updatecustomer(id, customermodel) == true) {

				return new ResponseEntity<>(HttpStatus.CREATED);
				
			} 
			else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} 
	  }
	  
	  @DeleteMapping("/removecustomer/{id}")
	  public ResponseEntity<HttpStatus> deletecustomer( @PathVariable("id") long id) {
		  try {
			  
		      customerservice.deletecustomer(id);
		      return new ResponseEntity<>(HttpStatus.ACCEPTED) ; 
		      
		    } 
		  
		 catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ; 
		      
		    }
	  }
	  
}


