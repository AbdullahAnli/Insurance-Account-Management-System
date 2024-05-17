package com.InsuranceAccountManagementSystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @ManyToOne
    private Policy policy;
    @ManyToOne
    private Customer customer;

    public Payment() {

    }

    public Payment(double amount, Date paymentDate, Policy policy, Customer customer) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.policy = policy;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
