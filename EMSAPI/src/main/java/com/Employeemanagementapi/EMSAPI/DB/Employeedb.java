package com.Employeemanagementapi.EMSAPI.DB;

import java.util.List;

import com.Employeemanagementapi.EMSAPI.model.Employee;

public interface Employeedb 
{
    public List<Employee> findAll();
    
    public Employee findById(int theId);
    
    public void save(Employee theEmployee);
    
    public void deleteById(int theId);
    
}