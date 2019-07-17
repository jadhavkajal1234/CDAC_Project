package com.app.dao;

import com.app.pojos.Employee;

public interface IEmployeeDao {
	Employee validateEmployee(String email, String pass);
}
