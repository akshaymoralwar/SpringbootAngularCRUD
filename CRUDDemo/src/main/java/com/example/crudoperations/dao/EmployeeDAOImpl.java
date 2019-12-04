/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudoperations.bean.EmployeeBean;
import com.example.crudoperations.controller.EmployeeController;
import com.example.crudoperations.controller.ManagerController;

/*Implementation of EmployeeDAO interface.*/
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	@Autowired
	private EntityManager entityManager;

	/*
	 * Returns list of employees.
	 * 
	 * @return empList
	 */
	@Override
	public List<EmployeeBean> get() {
		List<EmployeeBean> empList = null;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<EmployeeBean> query = currentSession.createQuery("from EmployeeBean", EmployeeBean.class);
			empList = query.getResultList();
		} catch (Exception e) {
			logger.info("Exception in fetching records");
			e.printStackTrace();
		}
		return empList;
	}

	/*
	 * Return a specific employee record.
	 * 
	 * @return employee
	 */
	@Override
	public EmployeeBean get(int empId) {
		EmployeeBean employee=null;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			employee = currentSession.get(EmployeeBean.class, empId);
		} catch (Exception e) {
			logger.info("Employee record not found...");
			e.printStackTrace();
		}
		return employee;
	}

	/*
	 * Save the record in the database.
	 * 
	 * @param employee
	 */
	@Override
	public void save(EmployeeBean employee) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(employee);
		} catch (Exception e) {
			logger.info("Employee record cannot be saved due to exception");
			e.printStackTrace();
		}
	}

	/*
	 * Deletes a specific record.
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			EmployeeBean employee = currentSession.get(EmployeeBean.class, id);
			currentSession.delete(employee);
		} catch (Exception e) {
			logger.info("Unable to delete employee record...");
			e.printStackTrace();
		}
	}
}
