package com.learn.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.entity.Employee;
import com.learn.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository er;
	
	
	public EmployeeServiceImplementation(EmployeeRepository er) {
		super();
		this.er = er;
	}


	@Override
	public String createEmployee(Employee e) {
		er.save(e);
		
		return "created";
	}


	@Override
	public List<Employee> show() {
		List<Employee> emp=er.findAll();
		return emp;
	}
	

	@Override
	public String updateEmployee(Employee b, int eid) {
		Employee e=er.findById(eid).get();
		e.setEname(e.getEname());
		e.setPhoneNo(e.getPhoneNo());
		e.setSalary(e.getSalary());
		er.save(e);
		return "updated";
	}

	@Override
	public String deleteEmployee(int eid) {
		er.deleteById(eid);
		return "delete";
	}

	
}
