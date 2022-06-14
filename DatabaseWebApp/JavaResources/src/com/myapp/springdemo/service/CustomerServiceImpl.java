package com.myapp.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.springdemo.dao.CustomerDao;
import com.myapp.springdemo.entity.Customer;

//This is the service class now which will implement our business logic.
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	@Transactional
	//this manages our transaction.We don't have to specify the beginning and end of transaction.
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}


	@Transactional
	@Override
	public void saveCustomer(Customer theData) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(theData);
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}


	@Transactional
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(id);
	}
}
