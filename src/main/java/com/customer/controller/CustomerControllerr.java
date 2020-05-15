package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entities.Customer;
import com.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerControllerr {

	// Dependency of Service Interface
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

//	List of all Employees
	@GetMapping("/list")
	public List<Customer> listCustomers() {
		return customerServiceImpl.getCustomers();
	}

//	Find Customer by id
	@GetMapping("/list/{customerId}")
	public Customer getEmployee(@PathVariable int customerId) {
		Customer customer = customerServiceImpl.findById(customerId);
		if (customer == null) {
			throw new RuntimeException("Customer not found");
		}
		return customer;
	}

	// Saving Customer
	@PostMapping("/add")
	public Customer addEmployee(@RequestBody Customer customer) {
		customerServiceImpl.save(customer);
		return customer;
	}

	// Update Customer
	@PutMapping("/update")
	public Customer updateEmployee(@RequestBody Customer customer) {
		customerServiceImpl.save(customer);
		return customer;
	}

//	Delete Customer by id
	@DeleteMapping("/delete/{customerId}")
	public String deleteEmployee(@PathVariable int customerId) {
		Customer customer = customerServiceImpl.findById(customerId);
		if (customer == null) {
			throw new RuntimeException("Customer not found");
		}
		customerServiceImpl.delete(customerId);
		return " Deleted Customer id : " + customerId;
	}

}
