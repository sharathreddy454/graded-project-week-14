package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.Employee;
import com.gl.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String getEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employeesList";
	}
	
	@RequestMapping("/add")
	public String showAddEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employeeForm";
	}
	
	@RequestMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id,Model model)
	{
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employeeForm";
	}
	
	@RequestMapping("/save")
	public String saveEmployee(@RequestParam("id") int id,
								@RequestParam("empName") String empName,
								@RequestParam("empAddress") String empAddress,
								@RequestParam("empNo") String empNo,
								@RequestParam("empSalary") String empSalary,Model model)
	{
		Employee employee = new Employee();
		if(id != 0)
		{
			employee = employeeService.getEmployeeById(id);
			employee.setEmpName(empName);
			employee.setEmpAddress(empAddress);
			employee.setEmpNo(empNo);
			employee.setEmpSalary(empSalary);
		}
		else
		{
			employee = new Employee(empName,empAddress,empNo,empSalary);
		}
		employeeService.saveEmployee(employee);
		return "redirect:/employee/list";
	}
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/employee/list";
	}
}
