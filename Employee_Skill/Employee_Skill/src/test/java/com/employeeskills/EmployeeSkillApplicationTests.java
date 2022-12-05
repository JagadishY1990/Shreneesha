package com.employeeskills;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.employeeskills.Model.Employee;
import com.employeeskills.Service.EmployeeService;
import com.employeeskills.dao.EmployeeDao;
import com.employeeskills.dto.EmployeeDto;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeSkillApplicationTests {
	@Mock
	private EmployeeDao employeeDao;
	@InjectMocks
	private EmployeeService employeeService;

	@Test
	public void whenSaveUser_shouldReturnUser() {
		EmployeeDto empDto = new EmployeeDto();
		empDto.setEmpname("Test Name");
		Employee emp = new Employee();
		emp.setEmpname(empDto.getEmpname());
		when(employeeDao.save(ArgumentMatchers.any(Employee.class))).thenReturn(emp);
		Employee created = employeeService.addEmployee(empDto);
		assertThat(created.getEmpname()).isSameAs(emp.getEmpname());
		verify(employeeDao).save(emp);
	}

	@Test
	public void shouldReturnAllUsers() {
		List<Employee> employees = new ArrayList();
		Employee emp = new Employee();
		emp.setEmpname("Test Name");
		employees.add(new Employee());
		given(employeeDao.findAll()).willReturn(employees);
		List<Employee> expected = employeeService.getAllEmployees();
		assertEquals(expected, employees);
		assertTrue(expected.size() > 0);
		verify(employeeDao).findAll();
	}

	@Test
	public void whenUpdateUser_shouldReturnUser() {
		EmployeeDto empDto = new EmployeeDto();
		empDto.setEmpname("Test Name");
		empDto.setEmployeeID(1);
		Employee emp = new Employee();
		emp.setEmpname(empDto.getEmpname());
		emp.setEmployeeID(empDto.getEmployeeID());
		when(employeeDao.save(ArgumentMatchers.any(Employee.class))).thenReturn(emp);
		employeeService.updateEmployee(empDto, 1);
		assertThat(emp.getEmployeeID()).isSameAs(1);
		verify(employeeDao).save(emp);
	}

	@Test
	public void whenDeleteUserSuccess() {
		Employee emp = new Employee();
		emp.setEmpname("Test Name");
		emp.setEmployeeID(1);
		doNothing().when(employeeDao).deleteById(1);
		employeeService.deleteEmployeeByID(1);
		verify(employeeDao).deleteById(1);
	}

}