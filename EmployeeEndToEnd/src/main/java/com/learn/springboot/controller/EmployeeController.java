package com.learn.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.springboot.entity.Employee;
import com.learn.springboot.service.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	

	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}

	@GetMapping("home")
	public String home()
	{
		return "index";
	}
	
	
	@GetMapping("add")
	public String addStudent()
	{
		return "addemployee";
	}

	@PostMapping("employee")
	public String createEmployee(@ModelAttribute  Employee e) {
		
		es.createEmployee(e);
		return "success";
	}
	
	@GetMapping("view")
	public String viewEmployees(Model model) {
        List<Employee> employees = es.show();
        model.addAttribute("employees", employees);
        return "viewshow";
    }
	
	@PutMapping("update/{eid}")
	public String updateEmployee(@RequestBody Employee e, @PathVariable int eid) {
		es.updateEmployee( e, eid);
		return "updatedeemp";
	}
	
	
	@DeleteMapping("delete/{eid}")
	public String deleteEmployee(@PathVariable int eid) {
	    es.deleteEmployee(eid);
	    return "deleteemp";
	}




}
