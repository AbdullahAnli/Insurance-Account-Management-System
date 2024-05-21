package com.InsuranceAccountManagementSystem.controller;

import com.InsuranceAccountManagementSystem.entity.Customer;
import com.InsuranceAccountManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/all")
    public List<Customer>getAllCustomer(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer>getByCustomerId(@PathVariable Long id){
        Optional<Customer>customer=customerService.getByCustomerId(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer createCustomer= customerService.saveCustomer(customer);
        return new ResponseEntity<>(createCustomer, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer>updateCustomer(@PathVariable Long id,@RequestBody Customer updateCustomer){
        try {
            Customer customer=customerService.updateCustomer(id,updateCustomer);
            return ResponseEntity.ok(customer);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping
    public ResponseEntity<Void>deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
