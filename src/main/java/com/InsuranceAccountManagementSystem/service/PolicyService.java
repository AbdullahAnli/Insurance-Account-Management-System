package com.InsuranceAccountManagementSystem.service;

import com.InsuranceAccountManagementSystem.entity.Policy;
import com.InsuranceAccountManagementSystem.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy>getAllPolicy(){
        return policyRepository.findAll();
    }
    public Optional<Policy>getByPolicyId(Long id){
        return policyRepository.findById(id);
    }
    public Policy savePolicy(Policy policy){
        return policyRepository.save(policy);
    }
    public void deletePolicy(Long id){
        policyRepository.deleteById(id);
    }
    public double calculateTotalPremium(){
        return policyRepository.findAll().stream()
                .mapToDouble(Policy::getPremium)
                .sum();
    }



}
