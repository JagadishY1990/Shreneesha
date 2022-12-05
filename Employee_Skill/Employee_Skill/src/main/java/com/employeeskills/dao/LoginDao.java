package com.employeeskills.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.employeeskills.Model.Login;
import com.employeeskills.dto.LoginDto;

public interface LoginDao extends CrudRepository<Login, String>{

	List<Login> findByUnameAndPswAndRole(String uname, String role, String psw);

	void save(LoginDto loginDto);

}
