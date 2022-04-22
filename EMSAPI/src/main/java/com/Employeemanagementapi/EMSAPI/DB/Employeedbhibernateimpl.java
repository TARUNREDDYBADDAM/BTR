package com.Employeemanagementapi.EMSAPI.DB;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Employeemanagementapi.EMSAPI.model.Employee;

@Repository
public class Employeedbhibernateimpl implements Employeedb
{
    private EntityManager entityManager;
    
    @Autowired
    public Employeedbhibernateimpl(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }
    
    @Override
    public List<Employee> findAll() 
    {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee order by salary DESC", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) 
    {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = currentSession.get(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) 
    {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) 
    {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update Employee set salary= 10000 where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
    
}