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
    public Customer updateCustomer(Long id ,Customer updateCustomer){
        Optional<Customer>optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(updateCustomer.getName());
            existingCustomer.setName(updateCustomer.getEmail());
            return customerRepository.save(existingCustomer);
        }
        else{
            throw new IllegalArgumentException("Customer not found");
        }
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
