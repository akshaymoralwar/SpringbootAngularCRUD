/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudoperations.bean.EmployeeBean;
import com.example.crudoperations.dao.EmployeeDAO;

/*Implementation of EmployeeService interface.*/
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	/*
	 * Returns list of employees
	 * 
	 * @return List<EmployeeBean>
	 */
	@Transactional
	@Override
	public List<EmployeeBean> get() {
		return employeeDao.get();
	}

	/*
	 * Returns a specific employee record.
	 * 
	 * @param id
	 * 
	 * @return List<EmployeeBean>
	 */
	@Transactional
	@Override
	public EmployeeBean get(int id) {
		return employeeDao.get(id);
	}

	/*
	 * Method to save the record
	 * 
	 * @param employee
	 */
	@Transactional
	@Override
	public void save(EmployeeBean employee) {
		employeeDao.save(employee);
	}

	/*
	 * Deletes a specific record
	 * 
	 * @param id
	 * 
	 * @return List<EmployeeBean>
	 */
	@Transactional
	@Override
	public void delete(int id) {
		employeeDao.delete(id);

	}

}
