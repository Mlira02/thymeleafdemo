package com.marcos.thymeleafdemo.service;

import com.marcos.thymeleafdemo.dao.EmployeeRepository;
import com.marcos.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }

//    @Transactional is commented out because the spring data JPA uses @Transactional out of the box

    @Override
//    @Transactional
    public List<Employee> findAll()
    {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
//    @Transactional
    public Employee findById(int employeeId)
    {
        Optional<Employee> result = employeeRepository.findById(employeeId);

        Employee theEmployee = null;
        if(result.isPresent())
        {
            theEmployee = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find employee id: " + employeeId);
        }
        return theEmployee;
    }

    @Override
//    @Transactional
    public void save(Employee theEmployee)
    {
        employeeRepository.save(theEmployee);
    }

    @Override
//    @Transactional
    public void deleteById(int employeeId)
    {
        employeeRepository.deleteById(employeeId);
    }
}
