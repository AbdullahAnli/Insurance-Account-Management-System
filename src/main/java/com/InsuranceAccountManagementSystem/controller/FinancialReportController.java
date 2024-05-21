package com.InsuranceAccountManagementSystem.controller;

import com.InsuranceAccountManagementSystem.service.FinancialReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/reports")
public class FinancialReportController {
    @Autowired
    private FinancialReportService financialReportService;

    @GetMapping("/total-revenue")
    public double getTotalRevenue(){
        return financialReportService.generateTotalRevenueReport();
    }
    @GetMapping("/total-premium")
    public double getTotalPremium(){
        return financialReportService.generateTotalPremiumReport();
    }
}
