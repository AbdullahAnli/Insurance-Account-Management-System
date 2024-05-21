package com.InsuranceAccountManagementSystem.controller;

import com.InsuranceAccountManagementSystem.entity.Payment;
import com.InsuranceAccountManagementSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/all")
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment>getByIdPayment(@PathVariable Long id){
        Optional<Payment>payment=paymentService.getByPaymentId(id);
        return payment.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ResponseEntity<Payment>createPayment(@RequestBody Payment payment){
        Payment createPayment = paymentService.savePayment(payment);
        return new ResponseEntity<>(createPayment, HttpStatus.CREATED);
    }
    @PostMapping("/process")
    public ResponseEntity<Payment>processPayment(@RequestParam Long policyId,@RequestParam Long customerId,
                                                 @RequestParam double amount){
        try {
            Payment payment =paymentService.processPayment(policyId,customerId,amount);
            return ResponseEntity.ok(payment);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Payment>updatePayment(@PathVariable Long id,@RequestBody Payment updatePayment){
         try {
             Payment payment = paymentService.updatePayment(id,updatePayment);
             return ResponseEntity.ok(payment);
         }catch (IllegalArgumentException e){
             return ResponseEntity.noContent().build();
         }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
        return ResponseEntity.notFound().build();
    }
}
