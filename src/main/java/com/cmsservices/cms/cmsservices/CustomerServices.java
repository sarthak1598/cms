package com.cmsservices.cms.cmsservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cmsservices.cms.cmsentity.Customermodel;
import com.cmsservices.cms.controller.Tutorial;
import com.cmsservices.cms.repository.CustomerDb;

@Service
public class CustomerServices {

	 @Autowired
	 public CustomerDb customerdb ;
	 
	 // to return the list of all customers stored in the db 
	 public List<Customermodel> getCustomers() {
	        return customerdb.findAll();
	    }

	 // add new customer in the database 
	 public Customermodel addCustomer(Customermodel customermodel) {
		 return customerdb.save(customermodel);
	 }
	 
	 // update the existing student dob in the table 
	 public boolean updatecustomer(long id , Customermodel customermodel) {
		 Optional<Customermodel> customerd = customerdb.findById(id);

					if (customerd.isPresent()) {
						Customermodel customer = customerd.get();
						
						customer.setDob(customermodel.getDob());
						customer.setName(customermodel.getName());
						customerdb.save(customer);
						return true;
						
					} 
					else {
						return false;
					} 
		 
	 }
	 
	 // delete customer // set method return type as http status
	 public void deletecustomer(long id) {
		      customerdb.deleteById(id);
	 }

}
