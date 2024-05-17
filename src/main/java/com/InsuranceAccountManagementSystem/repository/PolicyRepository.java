package com.InsuranceAccountManagementSystem.repository;

import com.InsuranceAccountManagementSystem.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy ,Long> {
}
