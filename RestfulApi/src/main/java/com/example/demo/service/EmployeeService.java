package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(long id,Employee employee);
	void deleteEmployee(long id);
}
