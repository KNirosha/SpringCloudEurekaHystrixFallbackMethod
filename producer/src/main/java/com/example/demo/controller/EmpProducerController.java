package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmpProducerController {
	@Autowired
	EmployeeService employeeService;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@RequestMapping(method=RequestMethod.GET,value="/api/getAllEmployes")
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public List<Employee> getEmployeeList(){
		//creating an exceptional case to test the fallback method.
		int x=10, y=0;
		System.out.println("exception raising here::"+x/y);
		return null;
	}
	@RequestMapping(method=RequestMethod.POST,value="/api/employe")
	public Employee addEmployee(@RequestBody Employee e){
		return employeeService.addEmployee(e);
	}
	/*
	 * Create a method that returns the same type as actual API return type. List<Employee> 
	 * This method will get executed whenever there is a fall-back / exception in actual API.
	 */
	public List<Employee> getDataFallBack(){
		Employee e1= new Employee();
		e1.setId(new Long(123));
		e1.setName("KMS");
		e1.setSal(34500);
		e1.setDesig("SSE");
		
		Employee e2= new Employee();
		e2.setId(new Long(123));
		e2.setName("KMS");
		e2.setSal(34500);
		e2.setDesig("SSE");
		
		List<Employee> empListDefault=new ArrayList<>();
		empListDefault.add(e1);
		empListDefault.add(e2);
		
		return empListDefault;
	}

}
