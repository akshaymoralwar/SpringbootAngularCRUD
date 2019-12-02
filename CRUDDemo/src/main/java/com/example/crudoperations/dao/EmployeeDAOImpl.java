/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudoperations.bean.EmployeeBean;

/*Implementation of EmployeeDAO interface.*/
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	/*
	 * Returns list of employees.
	 * 
	 * @return empList
	 */
	@Override
	public List<EmployeeBean> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<EmployeeBean> query = currentSession.createQuery("from EmployeeBean", EmployeeBean.class);
		List<EmployeeBean> empList = query.getResultList();
		return empList;
	}

	/*
	 * Return a specific employee record.
	 * 
	 * @return employee
	 */
	@Override
	public EmployeeBean get(int empId) {
		Session currentSession = entityManager.unwrap(Session.class);
		EmployeeBean employee = currentSession.get(EmployeeBean.class, empId);
		return employee;
	}

	/*
	 * Save the record in the database.
	 * 
	 * @param employee
	 */
	@Override
	public void save(EmployeeBean employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	/*
	 * Deletes a specific record.
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		EmployeeBean employee = currentSession.get(EmployeeBean.class, id);
		currentSession.delete(employee);
	}
}
