package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.DAO.CustomerDAO;
import com.customer.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public void delete(int id) {
		customerDao.delete(id);
	}

}
