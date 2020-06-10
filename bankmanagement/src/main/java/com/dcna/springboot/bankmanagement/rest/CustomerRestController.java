/**
 * 
 */
package com.dcna.springboot.bankmanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcna.springboot.bankmanagement.entity.Customer;
import com.dcna.springboot.bankmanagement.service.CustomerService;

/**
 * @author TruongChinh
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerService customerService;

	/**
	 * Injection CustomerService
	 * @param customerService
	 */
	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * expose ("/customers) and return list of customer
	 * @return
	 */
	@GetMapping("/customers")
	public List<Customer> findAllCustomers(){
		return customerService.findAllCustomers();
	}
	
	
}
