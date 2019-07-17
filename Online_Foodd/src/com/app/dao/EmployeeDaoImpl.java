package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Employee;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Employee validateEmployee(String email, String pass) {
		String jpql = "select e from Employee e  where e.email=:em and e.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Employee.class).setParameter("em", email).setParameter("pa", pass)
				.getSingleResult();
	}

}
