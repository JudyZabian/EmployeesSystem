package com.EmployeesSystem.repository;

import com.EmployeesSystem.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
