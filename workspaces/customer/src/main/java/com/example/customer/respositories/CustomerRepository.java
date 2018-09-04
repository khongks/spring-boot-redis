package com.example.customer.respositories;

import com.example.customer.models.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Customer findById(Long id);
    public List<Customer> findByLastName(String lastName);
}