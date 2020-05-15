package com.customer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entities.Customer;

@Repository
public class CustomerDAOJpaImp implements CustomerDAO {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		Query query = entityManager.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
//		Save or Update Customer
		Customer theCustomer = entityManager.merge(customer);
		theCustomer.setId(theCustomer.getId());
	}

	@Override
	public void delete(int id) {
		Query query = entityManager.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
