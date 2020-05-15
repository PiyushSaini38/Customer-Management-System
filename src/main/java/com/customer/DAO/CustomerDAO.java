package com.customer.DAO;

import java.util.List;

import com.customer.entities.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	Customer findById(int id);

	void save(Customer customer);

	void delete(int id);

}