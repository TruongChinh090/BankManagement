/**
 * 
 */
package com.dcna.springboot.bankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	 * CustomerServiceImpl required a single bean, but 2 were found: customerDAOImpl and customerDAOJpaImpl
	 * So we can don't use one of both DAO implementation (commnet code or delete) 
	 * or using using @Qualifier to identify the bean that should be consumed
	 * @param customerDAO
	 */
	@Autowired
	public CustomerServiceImpl(@Qualifier("customerDAOJpaImpl")CustomerDAO customerDAO) {
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
