package com.example.pro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pro.Model.Customer;
import com.example.pro.Repo.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> sortCustomersByAsc(String firstName) {
        return customerRepository.findAll(Sort.by(firstName).ascending());
    }

    
}


