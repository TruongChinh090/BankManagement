/**
 * 
 */
package com.dcna.springboot.bankmanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/customers/{customerId}")
	public Customer findCustomerById(@PathVariable long customerId) {
		Customer customer = customerService.findCustomerById(customerId);
		
		if(customer == null) {
			throw new RuntimeException("Customer id is not found "+ customerId);
		}
		
		return customer;
	}
	
	// add new customer
	@PostMapping("/customers")
	public Customer saveCusotmer (@RequestBody Customer customer) {
		if(customer.getCustomerId() <= 0) {
			throw new RuntimeException("Customer id must be greater than 0.");
		}
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	// update exist customer
	@PutMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	// delete a cusstomer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomerById(@PathVariable long customerId) {
		Customer customer =  customerService.findCustomerById(customerId);
		if(customer == null) {
			throw new RuntimeException("Customer id is not found " + customerId);
		}
		customerService.deleteCustomerById(customerId);
		return "Deleted customer has id "+customerId;
	}
	
	
}
