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
	  public ResponseEntity<Customermodel> addcustomer(@RequestBody Customermodel customer) {
		  try {
			  
	         customerservice.addCustomer(customer); 
	         return new ResponseEntity<>(customer, HttpStatus.CREATED) ;
		  } 
		  
		  catch (Exception e) {
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
		  }
		  
	    }

	  @GetMapping("/getcustomers")
	    public ResponseEntity<List<Customermodel>> getcustomers() {
		  try {
			  
		    List<Customermodel> customers = customerservice.getCustomers();
		    return new ResponseEntity<>(customers , HttpStatus.OK) ;
		    // returns the list of customers stored in hiberanate db
		  }
		   catch (Exception e ) {
			   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ; 
		   }
		  
	    }
	  
	  
	  @PutMapping("/updatecustomer/{id}")
	  public ResponseEntity<HttpStatus> modifycustomer( @PathVariable("id") long id , @RequestBody Customermodel customermodel ) {
		  // api to update the details of particulat customer specified by id 
		  try {
			if (customerservice.updatecustomer(id, customermodel) == true) {

				return new ResponseEntity<>(HttpStatus.CREATED);
				
			} 
		  }
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} 
		  return null;
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


