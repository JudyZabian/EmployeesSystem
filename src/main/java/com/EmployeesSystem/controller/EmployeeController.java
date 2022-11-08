package com.EmployeesSystem.controller;

import com.EmployeesSystem.model.entity.EmployeeEntity;
import com.EmployeesSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build the api
    @PostMapping()
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        return new ResponseEntity<EmployeeEntity>(employeeService.saveEmployee(employeeEntity), HttpStatus.CREATED);
    }

    // get all employees
    @GetMapping
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //get employees by ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<EmployeeEntity>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    //update employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") long id
            ,@RequestBody EmployeeEntity employee){
        return new ResponseEntity<EmployeeEntity>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    // delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        // delete employee from DB
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("EmployeeEntity deleted successfully!.", HttpStatus.OK);
    }
}
