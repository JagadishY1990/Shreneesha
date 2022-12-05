package com.employeeskills.dao;


import com.employeeskills.Model.Employee;
import org.springframework.data.repository.CrudRepository;

// interface extending crud repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
