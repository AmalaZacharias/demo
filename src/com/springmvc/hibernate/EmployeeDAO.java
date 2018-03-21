package com.springmvc.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("employeedao")
public class EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		
		sessionFactory.openSession().saveOrUpdate(employeeEntity);		
	}

}
