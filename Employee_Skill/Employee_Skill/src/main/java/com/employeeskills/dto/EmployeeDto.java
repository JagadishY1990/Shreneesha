package com.employeeskills.dto;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private int employeeID;
    private String empname;
    private String department;
    private int yearsofexperience;
    private String qualification;
    private String certification;
    private String technicalskills;
}
