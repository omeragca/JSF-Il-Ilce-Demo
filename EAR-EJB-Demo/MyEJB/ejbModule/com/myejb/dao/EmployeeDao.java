package com.myejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.myejb.model.Employee;

@Stateless
public class EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	public void persistOrUpdate(Employee employee) {
		if (employee.getId() == null) {
			em.persist(employee);
		} else {
			Employee e = findById(employee.getId());
			if (e == null) {
				em.persist(employee);
			} else {
				em.merge(employee);
			}
		}
	}

	public Employee findById(Long id) {
		List<Employee> list = em.createQuery("Select e From Employee e Where e.id=:id", Employee.class)
				.setParameter("id", id).getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public Employee findByName(String name) {
		List<Employee> list = em.createQuery("Select e From Employee e Where e.name=:name", Employee.class)
				.setParameter("name", name).getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<Employee> finAll() {
		return em.createQuery("Select e From Employee e", Employee.class).getResultList();
	}

	public void remove(Employee employee) {
		em.remove(em.merge(employee));
	}

}
