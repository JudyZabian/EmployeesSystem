package com.EmployeesSystem.service;

import com.EmployeesSystem.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(long id);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity, long id);
    void deleteEmployee(long id);

}
