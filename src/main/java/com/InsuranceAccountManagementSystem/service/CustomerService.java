package com.InsuranceAccountManagementSystem.service;

import com.InsuranceAccountManagementSystem.entity.Customer;
import com.InsuranceAccountManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer>getAllCustomer(){
        return customerRepository.findAll();
    }
    public Optional<Customer>getByCustomerId(Long id){
        return customerRepository.findById(id);
    }
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
