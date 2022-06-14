package com.myapp.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.springdemo.entity.Customer;

@Repository
//This helps in exception translation and used for DAO(data access objects) classes
public class CustomerDAOImpl implements CustomerDao {
	@Autowired
	// SessionFactory is injected into this class using @AutoWired
	private SessionFactory sessionFactory;

	@Transactional
	// We don't have to begin or end transactions. @Transaction will manage the
	// transaction of the current session.
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub

		// get the current session.
		Session session = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> query = session.createQuery("from Customer c order by lastName", Customer.class);
		// convert the Query into List and return it.
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer theData) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save or update the the data in to database
		session.saveOrUpdate(theData);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// retreive the data based on id
		Customer customer = session.get(Customer.class, id);

		return customer;

	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub

		// get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//delete the customer
		Query query=session.createQuery("delete from Customer c where c.id=:givenId");
		query.setParameter("givenId", theId);
		
		//execute the query
		query.executeUpdate();
	}

}
