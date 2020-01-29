package com.wanchopi.spring.dao;

import java.util.List;

import com.wanchopi.spring.entity.Employee;

/**
 * DAO Interface
 * @author Wanchopi
 *
 */
public interface IEmployeeDAO {
	
	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee e);
	public void deleteEmployee(long id);
	public Employee getEmployee(long id);

}
