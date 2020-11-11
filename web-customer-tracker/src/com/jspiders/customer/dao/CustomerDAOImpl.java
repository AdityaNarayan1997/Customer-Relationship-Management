package com.jspiders.customer.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspiders.customer.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create querry
		Query<Customer> query = session.createQuery("from Customer order by first_name", Customer.class);
		// return results
		List<Customer> list = query.getResultList();

		return list;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		/*
		 * Query query = session.createQuery("delete from Customer where id=:theId");
		 * query.setParameter("theId", id); query.executeUpdate();
		 */
	}

}
