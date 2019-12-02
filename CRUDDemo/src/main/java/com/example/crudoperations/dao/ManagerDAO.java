/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.dao;

import java.util.List;

import com.example.crudoperations.bean.EmployeeBean;
import com.example.crudoperations.bean.ManagerBean;

public interface ManagerDAO {

	boolean checkIfExistInDb(String username, String password);

	List<ManagerBean> get();

	void save(ManagerBean employee);

}
