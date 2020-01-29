package com.wanchopi.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wanchopi.spring.entity.Employee;

/**
 * Implements the IEmployeeDAO interface
 * @author Usuario
 *
 */
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAllEmployees() {
		@SuppressWarnings("unchecked")
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
	    return query.getResultList();
	}

	@Override
	public void saveEmployee(Employee e) {
		sessionFactory.getCurrentSession().saveOrUpdate(e);
	}

	@Override
	public void deleteEmployee(long id) {
		Employee employee = getEmployee(id);
		sessionFactory.getCurrentSession().delete(employee);
	}

	@Override
	public Employee getEmployee(long id) {
		Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
		return employee;
	}

}
