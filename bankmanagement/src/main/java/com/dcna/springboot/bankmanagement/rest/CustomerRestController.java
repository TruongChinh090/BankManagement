/**
 * 
 */
package com.dcna.springboot.bankmanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcna.springboot.bankmanagement.dao.CustomerDAO;
import com.dcna.springboot.bankmanagement.entity.Customer;

/**
 * @author TruongChinh
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerDAO customerDAO;

	/**
	 * Injection ConstomerDAO
	 * @param customerDAO
	 */
	@Autowired
	public CustomerRestController(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	/**
	 * expose ("/customers) and return list of customer
	 * @return
	 */
	@GetMapping("/customers")
	public List<Customer> findAllCustomers(){
		return customerDAO.findAllCustomers();
	}
	
	
}
