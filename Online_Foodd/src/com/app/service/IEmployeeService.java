package com.app.service;

import com.app.pojos.Employee;

public interface IEmployeeService {
	Employee validateEmployee(String email, String pass);
}
