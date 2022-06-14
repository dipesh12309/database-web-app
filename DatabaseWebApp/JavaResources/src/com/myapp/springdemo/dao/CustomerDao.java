package com.myapp.springdemo.dao;
import java.util.List;

import com.myapp.springdemo.entity.Customer;	
public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theData);

	public Customer getCustomer(int id);
	public void deleteCustomer(int id);
}
