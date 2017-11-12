package com.myejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.myejb.dao.EmployeeDao;
import com.myejb.model.Employee;

@Stateless
@Remote(EmployeeManager.class)
public class EmployeeManagerBean implements EmployeeManager {

	@EJB
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> findAll() {
		return employeeDao.finAll();
	}
}