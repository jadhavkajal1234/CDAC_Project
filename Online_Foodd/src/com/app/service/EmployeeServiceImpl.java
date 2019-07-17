package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDao;
import com.app.pojos.Employee;
@Repository
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public Employee validateEmployee(String email, String pass) {
		return dao.validateEmployee(email, pass);
	}

}
