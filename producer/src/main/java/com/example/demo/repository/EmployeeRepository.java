package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
@Repository
public class EmployeeRepository {
	
	List <Employee> employeesList=new ArrayList<Employee>();

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}
	
	public Employee addEmployee(Employee e){
		if(employeesList.add(e))
			{
				return e;
			}
		return null;
	}
	
	public List <Employee> getAll(){
		return employeesList;
	}

}
