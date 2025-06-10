package com.abdulkadersafi.mvc_crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abdulkadersafi.mvc_crud.entities.Employee;
import com.abdulkadersafi.mvc_crud.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getMethodNamePage(Model model) {
        // Get the employees from db
        List<Employee> employees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/add")
    public String addEmployeePage(Model model) {
        // add to the spring model
        model.addAttribute("employee", new Employee());

        return "employees/add-employee";
    }

    @PostMapping("/add")
    public String addEmployeeLogic(
            @ModelAttribute("employee") Employee employee,
            Model model) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployeeLogic(
            @RequestParam("id") int id,
            Model model) {
        Optional<Employee> employee = employeeService.findById(id);

        if (employee.isEmpty()) {
            return "redirect:/employees/list";
        }

        model.addAttribute("employee", employee);

        return "employees/update-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployeeLogic(
            @RequestParam("id") int id,
            Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isEmpty()) {
            return "redirect:/employees/list";
        }

        employeeService.delete(id);

        return "redirect:/employees/list";
    }

}
