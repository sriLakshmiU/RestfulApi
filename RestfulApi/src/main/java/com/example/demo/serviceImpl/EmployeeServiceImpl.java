package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		 Optional<Employee> employee = employeeRepository.findById(id);
		 if(employee.isPresent()) {
			 return employee.get();
		 }else {
			 throw new ResourceNotFoundException("Employee", "id", id);
		 }
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Employee newEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("employee", "id", id)
				);
		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setEmail(employee.getEmail());
		employeeRepository.save(newEmployee);
		return newEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id) );
		employeeRepository.deleteById(id);
	}
	
}
