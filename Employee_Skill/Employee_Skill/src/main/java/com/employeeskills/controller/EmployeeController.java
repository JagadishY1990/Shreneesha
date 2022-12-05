package com.employeeskills.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeeskills.Model.Employee;
import com.employeeskills.Service.EmployeeService;
import com.employeeskills.constants.ApplicationConstants;
import com.employeeskills.dto.EmployeeDto;
import com.employeeskills.dto.LoginDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    // inserting employee
    @GetMapping("/login")
    public String login() {
        log.info("Received request for login");
        return ApplicationConstants.LOGIN_SCREEN;
    }
    
    // inserting employee
    @PostMapping("/loginSubmit")
    public String loginSubmit(HttpServletRequest request, @ModelAttribute LoginDto loginDto) {
        log.info("Received request for login");
        String status = employeeService.login(loginDto);
        loginDto.setStatus(status);
        request.getSession().setAttribute("userObject", loginDto);
        request.setAttribute("loginDetails", loginDto);
        return ApplicationConstants.LOGIN_SCREEN;
    }

    // displaying list of all employees
    @GetMapping("/employees")
    public String getAllEmployee(HttpServletRequest request) {
        log.info("Received request for getting all employees");
        List<Employee> empList = employeeService.getAllEmployees();
        log.info("Total num of employees = " + empList.size());
        request.setAttribute("listEmployee", empList);
        return ApplicationConstants.EMP_LIST_SCREEN;
    }

    @GetMapping("/home")
    public String showHomePage(HttpServletRequest request) {
        log.info("Received request for home page");
        return ApplicationConstants.EMP_LIST_SCREEN;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(HttpServletRequest request, @PathVariable int id) {
        log.info("Received request for getting all employees");
        Optional<Employee> existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee.isPresent())
            request.setAttribute("employee", existingEmployee.get());
        return ApplicationConstants.EMP_FORM_SCREEN;
    }

    // displaying employee by id
    @GetMapping("/employees/{id}")
    public String getEmployee(HttpServletRequest request, @PathVariable int id) {
        log.info("Received request for getting employee with empid =" + id);
        Optional<Employee> existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee.isPresent())
            request.setAttribute("employee", existingEmployee.get());
        return ApplicationConstants.EMP_FORM_SCREEN;
    }

    // inserting employee
    @PostMapping("/addEmployees")
    public String addEmployees(HttpServletRequest request, @ModelAttribute EmployeeDto empDto) {
        log.info("Received request for adding employee with emp Name =" + empDto.getEmpname());
        employeeService.addEmployee(empDto);
        return getAllEmployee(request);
    }

    //updating employee by id
    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@ModelAttribute EmployeeDto empDto, @PathVariable int id, HttpServletRequest request) {
        log.info("Received request for updating employee with empid =" + id);
        employeeService.updateEmployee(empDto, id);
        log.info("Successfully updated employee with empid = " + id);
        return getAllEmployee(request);
    }

    // deleting employee by id
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployeeByID(@PathVariable int id, HttpServletRequest request) {
        log.info("Received request for deleting employee with empid =" + id);
        employeeService.deleteEmployeeByID(id);
        log.info("Successfully deleted employee with empid =" + id);
        return getAllEmployee(request);
    }
    
    // inserting employee
    @PostMapping("/addUsersForLogin")
    public void addUsersForLogin(HttpServletRequest request, @ModelAttribute LoginDto loginDto) {
        employeeService.addUsersForLogin(loginDto);
    }
}

