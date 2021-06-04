package com.marcos.thymeleafdemo.controller;

import com.marcos.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData()
    {
        Employee emp1 = new Employee(1, "Mark", "Something", "something@gmail.com");
        Employee emp2 = new Employee(2, "Someone", "Else", "someone@gmail.com");
        Employee emp3 = new Employee(3, "Garfield", "Andrews", "garfield@gmail.com");


        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}