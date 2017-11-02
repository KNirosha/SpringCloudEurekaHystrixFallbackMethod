package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee addEmployee(Employee e) {
		return empRepo.addEmployee(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.getAll();
	}

	public EmployeeRepository getEmpRepo() {
		return empRepo;
	}

	public void setEmpRepo(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	

}
