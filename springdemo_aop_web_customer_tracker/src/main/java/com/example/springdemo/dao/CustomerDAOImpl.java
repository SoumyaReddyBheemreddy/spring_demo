package com.example.springdemo.dao;

import com.example.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
         Session currentSession = sessionFactory.getCurrentSession();
        //create a query ... sort by last name
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
        //execute query and get result
        List<Customer> customers = query.getResultList();
        //return the results

        return customers;
    }
    @Override
    public Customer getCustomers(int id) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //get customer by id
        Customer customer = currentSession.get(Customer.class,id);

        //return the results

        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }
}
