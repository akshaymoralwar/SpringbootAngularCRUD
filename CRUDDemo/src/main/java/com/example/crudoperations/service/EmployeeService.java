/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.service;

import java.util.List;

import com.example.crudoperations.bean.EmployeeBean;

public interface EmployeeService {
	List<EmployeeBean> get();

	EmployeeBean get(int id);

	void save(EmployeeBean employee);

	void delete(int id);
}

