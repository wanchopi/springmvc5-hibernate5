package com.wanchopi.spring.service;

import java.util.List;

import com.wanchopi.spring.entity.Employee;

/**
 * Service
 * @author Wanchopi
 *
 */
public interface IEmployeeService {
	
	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee e);
	public void deleteEmployee(long id);
	public Employee getEmployee(long id);

}
