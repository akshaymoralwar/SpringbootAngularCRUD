/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.service;

import java.util.List;

import com.example.crudoperations.bean.EmployeeBean;
import com.example.crudoperations.bean.ManagerBean;

public interface ManagerService {
	List<ManagerBean> get();

	EmployeeBean get(int id);

	void save(ManagerBean manager);

	void delete(int id);
}
