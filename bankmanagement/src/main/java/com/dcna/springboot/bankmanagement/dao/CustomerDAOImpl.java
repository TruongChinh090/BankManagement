/**
 * 
 */
package com.dcna.springboot.bankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dcna.springboot.bankmanagement.entity.Customer;

/**
 * @author TruongChinh
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Define field for entityManager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional // add transaction to handles transaction management so we don't have to manually start and commit transaction
	public List<Customer> findAllCustomers() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query using native Hibernate API
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute the query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return result list
		return customers;
	}

}
