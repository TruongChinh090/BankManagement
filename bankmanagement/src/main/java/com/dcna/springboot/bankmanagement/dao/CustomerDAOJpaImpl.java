/**
 * 
 */
package com.dcna.springboot.bankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dcna.springboot.bankmanagement.entity.Customer;

/**
 * @author TruongChinh
 *
 */
@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {
	

	// Define field for entityManager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public CustomerDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {
		Query query  = entityManager.createQuery("from Customer");
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer findCustomerById(long customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// save or update customer
		Customer dbCustomer = entityManager.merge(customer);
		//update with id from database
		customer.setCustomerId(dbCustomer.getCustomerId());
	}

	@Override
	public void deleteCustomerById(long customerId) {
		
		Query query = entityManager.createQuery("delete from Customer where customerId =: customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

}
