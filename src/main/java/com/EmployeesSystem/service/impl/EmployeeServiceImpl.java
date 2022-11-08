package com.EmployeesSystem.service.impl;

import com.EmployeesSystem.exception.ResourceNotFoundException;
import com.EmployeesSystem.model.entity.EmployeeEntity;
import com.EmployeesSystem.repository.EmployeeRepository;
import com.EmployeesSystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(long id) {

       /* Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            return employeeEntity.get();
        } else {
            throw new ResourceNotFoundException("EmployeeEntity", "Id", id);
        }*/
            return employeeRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("EmployeeEntity", "Id", id));

        }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity, long id) {

        //check whether an employeeEntity with given id exists in the DB
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("EmployeeEntity", "Id", id));

        existingEmployee.setFirstName(employeeEntity.getFirstName());
        existingEmployee.setLastName(employeeEntity.getLastName());
        existingEmployee.setEmail(employeeEntity.getEmail());

        // save employeeEntity to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        // check whether an employeeEntity exist in the DB
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("EmployeeEntity", "Id", id));
        employeeRepository.deleteById(id);
    }
}