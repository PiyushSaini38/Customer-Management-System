package com.customer.service;

import java.util.List;

import com.customer.entities.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	Customer findById(int id);

	void save(Customer customer);

	void delete(int id);

}
