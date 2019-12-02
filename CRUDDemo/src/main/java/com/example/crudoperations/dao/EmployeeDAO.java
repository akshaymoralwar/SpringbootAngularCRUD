/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.dao;

import java.util.List;

import javax.persistence.Column;

import com.example.crudoperations.bean.EmployeeBean;

public interface EmployeeDAO {

	List<EmployeeBean> get();

	EmployeeBean get(int id);

	void save(EmployeeBean employee);

	void delete(int id);

}
