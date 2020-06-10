/**
 * 
 */
package com.dcna.springboot.bankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcna.springboot.bankmanagement.dao.CustomerDAO;
import com.dcna.springboot.bankmanagement.entity.Customer;

/**
 * @author TruongChinh
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	/**
	 * @param customerDAO
	 */
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional // add transaction to handles transaction management so we don't have to manually start and commit transaction
	public List<Customer> findAllCustomers() {
		return customerDAO.findAllCustomers();
	}

	@Override
	@Transactional // add transaction to handles transaction management so we don't have to manually start and commit transaction
	public Customer findCustomerById(long customerId) {
		return customerDAO.findCustomerById(customerId);
	}

	@Override
	@Transactional // add transaction to handles transaction management so we don't have to manually start and commit transaction
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional // add transaction to handles transaction management so we don't have to manually start and commit transaction
	public void deleteCustomerById(long customerId) {
		customerDAO.deleteCustomerById(customerId);
	}

}
