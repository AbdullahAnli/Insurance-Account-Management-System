package com.InsuranceAccountManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialReportService {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PolicyService policyService;

    public double generateTotalRevenueReport(){
        return paymentService.calculateTotalPayment();
    }
    public double generateTotalPremiumReport(){
        return policyService.calculateTotalPremium();
    }
}
