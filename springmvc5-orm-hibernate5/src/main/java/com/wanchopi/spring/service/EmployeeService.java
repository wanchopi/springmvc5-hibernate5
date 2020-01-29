package com.wanchopi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanchopi.spring.dao.IEmployeeDAO;
import com.wanchopi.spring.entity.Employee;

/**
 * Implements the IEmployeeService interface
 * @author Wanchopi
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee e) {
		employeeDAO.saveEmployee(e);
	}

	@Override
	@Transactional
	public void deleteEmployee(long id) {
		employeeDAO.deleteEmployee(id);
	}

	@Override
	@Transactional
	public Employee getEmployee(long id) {
		return employeeDAO.getEmployee(id);
	}

}
