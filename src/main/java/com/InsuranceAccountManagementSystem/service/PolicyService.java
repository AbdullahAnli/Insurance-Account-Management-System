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
    public Policy updatePolicy(Long id , Policy updatePolicy){
        Optional<Policy>optionalPolicy = policyRepository.findById(id);
        if (optionalPolicy.isPresent()){
            Policy existingPolicy = optionalPolicy.get();
            existingPolicy.setPolicyNumber(updatePolicy.getPolicyNumber());
            existingPolicy.setPremium(updatePolicy.getPremium());
            return policyRepository.save(existingPolicy);
        }
        else {
            throw new IllegalArgumentException("Policy not found");
        }
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
