package com.learn.springboot.service;

import java.util.List;


import com.learn.springboot.entity.Employee;

public interface EmployeeService {
	
	public String createEmployee(Employee e);
	
	public List<Employee> show();
	
	public String updateEmployee(Employee b, int eid);
	
	public String deleteEmployee(int eid);

	
	
}
