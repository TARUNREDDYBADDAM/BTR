package com.Employeemanagementapi.EMSAPI.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employeemanagementapi.EMSAPI.model.Employee;
import com.Employeemanagementapi.EMSAPI.service.Employeeservice;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
    private Employeeservice employeeService;
    
    @Autowired
    public EmployeeController(Employeeservice theEmployeeService)
    {
        employeeService = theEmployeeService;
    }
    
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll( );
    }
    
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        return theEmployee;
    }
    
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
     
         return theEmployee;
    }
    
    @PutMapping("/employeesu")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        employeeService.save(theEmployee);
        return theEmployee;
    }
    
    
    
}