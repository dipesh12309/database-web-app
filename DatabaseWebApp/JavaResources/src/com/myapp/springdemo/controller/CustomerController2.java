package com.myapp.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.myapp.springdemo.entity.Customer;
import com.myapp.springdemo.service.CustomerService;

@Controller
@RequestMapping("/save")
public class CustomerController2 {
	@Autowired
	//We have added an extra layer between 
	//CustomerController and CustomerDAO.This layer is Service layer and it manages all the transactions now.
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		List<Customer> customers=customerService.getCustomers();
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@GetMapping("/showAddForm")
	public String showForm()
	{
		Model theModel=null;
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "show-form";
	}
	
}
