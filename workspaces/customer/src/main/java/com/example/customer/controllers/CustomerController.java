package com.example.customer.controllers;

import java.util.List;

import com.example.customer.models.Customer;
import com.example.customer.services.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> listCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        if(customers.isEmpty()) {
            logger.error("No customers found.");
            return new ResponseEntity<Iterable<Customer>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long id) {
        logger.info("Get customer with id {}.", id);
        Customer cust = customerService.findById(id);
        if(cust == null) {
            logger.error("Customer with id {} not found.", id);
            return new ResponseEntity<String>("Customer with id " + id + " not found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Customer>(cust, HttpStatus.OK);
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer cust = customerService.saveCustomer(customer);
        if(cust == null) {
            logger.error("Customer not created.");
            return new ResponseEntity<String>("Customer not created.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<Long>(cust.getId(), HttpStatus.CREATED);
        }
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer cust = customerService.updateCustomer(id, customer);
        if(cust == null) {
            logger.error("Customer with id {} not found.", id);
            return new ResponseEntity<String>("Customer with id " + id + " not found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Customer>(cust, HttpStatus.OK);
        }
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}