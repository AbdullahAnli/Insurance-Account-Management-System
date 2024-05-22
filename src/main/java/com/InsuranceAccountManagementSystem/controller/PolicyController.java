package com.InsuranceAccountManagementSystem.controller;

import com.InsuranceAccountManagementSystem.entity.Policy;
import com.InsuranceAccountManagementSystem.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @GetMapping("/all")
    public List<Policy>getAllPolicy(){
        return policyService.getAllPolicy();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Policy>getByIdPolicy(@PathVariable Long id){
        Optional<Policy>policy=policyService.getByPolicyId(id);
        return policy.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Policy createPolicy(@RequestBody Policy policy){
        return policyService.savePolicy(policy);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Policy>updatePolicy(@PathVariable Long id,@RequestBody Policy updatepolicy){
        try {
            Policy policy = policyService.updatePolicy(id,updatepolicy);
            return ResponseEntity.ok(policy);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletePolicy(@PathVariable Long id){
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
