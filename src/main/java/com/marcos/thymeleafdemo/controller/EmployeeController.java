package com.marcos.thymeleafdemo.controller;

import com.marcos.thymeleafdemo.entity.Employee;
import com.marcos.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee theEmployee)
    {
        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }
}