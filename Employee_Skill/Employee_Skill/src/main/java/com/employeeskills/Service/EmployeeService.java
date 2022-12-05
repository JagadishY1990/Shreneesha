package com.employeeskills.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeskills.Model.Employee;
import com.employeeskills.Model.Login;
import com.employeeskills.dao.EmployeeDao;
import com.employeeskills.dao.LoginDao;
import com.employeeskills.dto.EmployeeDto;
import com.employeeskills.dto.LoginDto;

import lombok.extern.slf4j.Slf4j;

// employee service class
@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private LoginDao loginDao;

    // fetching all employees
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeDao.findAll();
    }

    // fetching employee by id
    public Optional<Employee> getEmployee(int id) {
        return employeeDao.findById(id);
    }

    // inserting employee
    public Employee addEmployee(EmployeeDto empDto) {
        log.info("Successfully saved employee data into DB");
        Employee empEty = dtoMapper(empDto);
        return employeeDao.save(empEty);
    }

	private Employee dtoMapper(EmployeeDto empDto) {
		Employee empEty = new Employee();
        empEty.setCertification(empDto.getCertification());
        empEty.setDepartment(empDto.getDepartment());
        empEty.setEmployeeID(empDto.getEmployeeID());
        empEty.setEmpname(empDto.getEmpname());
        empEty.setQualification(empDto.getQualification());
        empEty.setTechnicalskills(empDto.getTechnicalskills());
        empEty.setYearsofexperience(empDto.getYearsofexperience());
		return empEty;
	}

    // updating employee by id
    public void updateEmployee(EmployeeDto empDto, int id) {
    	Employee empEty = dtoMapper(empDto);
        if (id == empEty.getEmployeeID()) {
            employeeDao.save(empEty);
        } else {
            log.error("Employee details not matching");
        }
    }

    // deleting employee by id
    public void deleteEmployeeByID(int id) {
        employeeDao.deleteById(id);
    }

	public String login(LoginDto loginDto) {
		Login lgn = new Login();
		lgn.setUname(loginDto.getUname());
		lgn.setRole(loginDto.getRole());
		lgn.setPsw(loginDto.getPsw());
		List<Login> loginObj = loginDao.findByUnameAndPswAndRole(lgn.getUname(),lgn.getRole(),lgn.getPsw());
		return loginObj.size()>0?"SUCCESS":"FAILURE";
	}

	public void addUsersForLogin(LoginDto loginDto) {
		Login lgn = new Login();
		lgn.setUname(loginDto.getUname());
		lgn.setRole(loginDto.getRole());
		lgn.setPsw(loginDto.getPsw());
		loginDao.save(loginDto);
	}

}
