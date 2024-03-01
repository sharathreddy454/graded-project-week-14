package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeDAO;
import com.gl.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}
	
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}
}
