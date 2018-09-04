package com.example.customer.services;

import java.util.List;

import com.example.customer.models.Customer;
import com.example.customer.respositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.bytecode.Descriptor.Iterator;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
     
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return (List<Customer>)customerRepository.findAll();
    }
     
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }
     
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }
     
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
    public Customer updateCustomer(Long id, Customer customer) {
        Customer cust = customerRepository.findById(id);
        if(cust != null) {
            cust.setLastName(customer.getLastName());
            cust.setFirstName(customer.getFirstName());
            customerRepository.save(cust);
            return cust;
        } else {
            return null;
        }
    }
 
    public void deleteCustomerById(Long id) {
        customerRepository.delete(id);
    }
}
 