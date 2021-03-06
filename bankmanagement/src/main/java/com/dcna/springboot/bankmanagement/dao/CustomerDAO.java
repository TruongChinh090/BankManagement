/**
 * 
 */
package com.dcna.springboot.bankmanagement.dao;

import java.util.List;

import com.dcna.springboot.bankmanagement.entity.Customer;

/**
 * @author TruongChinh
 *
 */
public interface CustomerDAO {
	
	List<Customer> findAllCustomers();
	
	Customer findCustomerById(long customerId);
	
	void saveCustomer(Customer customer);
	
	void deleteCustomerById(long customerId);

}
