package com.gl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gl.model.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeDAO {
	
	SessionFactory sessionFactory;
	Session session;
	
	public EmployeeDAO(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		this.session=sessionFactory.openSession();
	}
	
	@Transactional
	public Employee getEmployeeById(int id) {
		Employee employee = new Employee();
		Transaction transaction = session.beginTransaction();
		employee=session.get(Employee.class, id);
		transaction.commit();
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		Transaction transaction = session.beginTransaction();
		List<Employee> employees = session.createQuery("from Employee").list();
		transaction.commit();
		return employees;
	}
	
	public void saveEmployee(Employee employee) {
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
	}
	
	public void deleteEmployee(int id) {
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, id);
		session.delete(employee);
		transaction.commit();
	}
}
