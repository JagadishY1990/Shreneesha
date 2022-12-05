package com.employeeskills.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER_DETAILS")
public class Login {
	private String role;
	@Id
    private String uname;
    private String psw;
}
