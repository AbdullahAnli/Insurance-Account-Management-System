package com.InsuranceAccountManagementSystem.service;

import com.InsuranceAccountManagementSystem.entity.Customer;
import com.InsuranceAccountManagementSystem.entity.Payment;
import com.InsuranceAccountManagementSystem.entity.Policy;
import com.InsuranceAccountManagementSystem.repository.CustomerRepository;
import com.InsuranceAccountManagementSystem.repository.PaymentRepository;
import com.InsuranceAccountManagementSystem.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PolicyRepository policyRepository;

    public List<Payment>getAllPayment(){
        return paymentRepository.findAll();
    }
    public Optional<Payment>getByPaymentId(Long id){
        return paymentRepository.findById(id);
    }
    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }
    public void deletePayment(Long id){
        paymentRepository.deleteById(id);
    }

    public Payment processPayment(Long policyId,Long customerId,double amount) {
        Optional<Policy> policyOpt = policyRepository.findById(policyId);
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (policyOpt.isPresent() && customerOpt.isPresent()) {
            Payment payment = new Payment();
            payment.setPolicy(new Policy(policyId));
            payment.setCustomer(new Customer(customerId));
            payment.setAmount(amount);
            payment.setPaymentDate(new Date());
            return paymentRepository.save(payment);
        }
        else {
            throw new IllegalArgumentException("Policy or Customer not found");
        }
    }
    public double calculateTotalPayment(){
        return paymentRepository.findAll().stream()
                .mapToDouble(Payment::getAmount)
                .sum();
    }
}
