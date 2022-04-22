package com.Employeemanagementapi.EMSAPI.service;



import java.util.List;

import com.Employeemanagementapi.EMSAPI.model.Employee;

public interface Employeeservice 
{
    public List<Employee> findAll();
    
    public Employee findById(int theId);
    
    public void save(Employee theEmployee);
    
    public void deletebyid(int theId);
   
    
}
