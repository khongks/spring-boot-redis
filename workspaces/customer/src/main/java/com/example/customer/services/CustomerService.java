package com.example.customer.services;

import java.util.List;
import com.example.customer.models.Customer;
 
public interface CustomerService {
    public Customer findById(Long id);
    public List<Customer> findByLastName(String name);
    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Long id, Customer customer);
    public void deleteCustomerById(Long id);
    public List<Customer> findAllCustomers();
}