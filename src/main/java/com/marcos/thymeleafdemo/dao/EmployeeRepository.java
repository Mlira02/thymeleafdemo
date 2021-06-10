package com.marcos.thymeleafdemo.dao;

import com.marcos.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

//    Check spring data JPA docs to check how to create more custom helper methods...
    public List<Employee> findAllByOrderByLastNameAsc();
}