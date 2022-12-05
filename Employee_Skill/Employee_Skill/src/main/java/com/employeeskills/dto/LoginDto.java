package com.employeeskills.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	private String role;
    private String uname;
    private String psw;
    private String status;
}
