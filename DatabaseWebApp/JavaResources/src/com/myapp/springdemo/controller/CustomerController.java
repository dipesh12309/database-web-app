package com.myapp.springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.springdemo.entity.Customer;
import com.myapp.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	//We have added an extra layer between 
	//CustomerController and CustomerDAO.This layer is Service layer and it manages all the transactions now.
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		List<Customer> customers=customerService.getCustomers();
		theModel.addAttribute("customers",customers);
		return "customer-list";
	}
	
	@GetMapping("/showAddForm")
	public String showForm(Model theModel)
	{
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveData(@ModelAttribute("customer")Customer theData)
	{
		
		//save the customer data into database
		customerService.saveCustomer(theData);
		//used redirect because It avoids duplicate POST requests to the server
		//when the user refreshes a page.
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateData(@RequestParam("cid")int id,Model theModel)
	{
		//get the customer from database
		Customer customer=customerService.getCustomer(id);
		System.out.println(customer);
		//populate the form with customer data
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("cid")int id)
	{
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	

}
