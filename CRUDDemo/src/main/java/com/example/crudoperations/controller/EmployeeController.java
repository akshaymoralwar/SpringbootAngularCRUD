/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperations.CrudDemoApplication;
import com.example.crudoperations.bean.EmployeeBean;
import com.example.crudoperations.service.EmployeeService;

/* Controller class used for URL mapping. REST API.*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	/*
	 * The method will return a list of all employee records available in the
	 * Database.
	 * 
	 * @return List<EmployeeBean>
	 * 
	 */
	@GetMapping("/getAllEmployee")
	public List<EmployeeBean> get() {
		List<EmployeeBean> employeeList = null;
		try {
			logger.info("Fetching employees...");
			employeeList = employeeService.get();
		} catch (Exception e) {
			logger.info("Exception while fetching employees...");
			e.printStackTrace();

		}
		return employeeList;
	}

	/*
	 * The method will save the data as a record in the database and return an
	 * EmployeeBean Object.
	 * 
	 * @param employee
	 * 
	 * @return employee
	 * 
	 */
	@PostMapping("/saveEmployee")
	public EmployeeBean save(@RequestBody EmployeeBean employee) {
		try {
			logger.info("Employee saved...");
			employeeService.save(employee);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	/*
	 * Returns a specific record of an Employee
	 * 
	 * @param id
	 * 
	 * @return employeeObj
	 */
	@GetMapping("/getEmployee/{id}")
	public EmployeeBean get(@PathVariable int id) {
		logger.info("Fetching employee with " + id);
		EmployeeBean employeeObj = employeeService.get(id);
		if (employeeObj == null) {
			throw new RuntimeException("Employee with id " + id + " not found");
		}
		return employeeObj;
	}

	/*
	 * Deletes a specific record with the id and returns a string.
	 * 
	 * @param id
	 * 
	 * @return message;
	 */

	@DeleteMapping("/deleteEmployee/{id}")
	public String delete(@PathVariable int id) {
		String message = null;
		try {
			logger.info("Deleting employee record with " + id);
			employeeService.delete(id);
			message = "Employee has been deleted with id " + id;
		} catch (Exception e) {
			logger.info("Exception while deleting....");
			e.printStackTrace();
		}
		return message;
	}

	/*
	 * Updates a specific record with the id and returns a string.
	 * 
	 * @param id
	 * 
	 * @param emploeeObj
	 * 
	 * @return message;
	 */

	@PutMapping("/updateEmployee{id}")
	public EmployeeBean update(@RequestBody EmployeeBean employeeObj, @PathVariable int id) {
		try {
			logger.info("Updating employee with record " + id);
			EmployeeBean updateBean = employeeService.get(id);
			employeeService.save(updateBean);
		} catch (Exception e) {
			logger.info("Exception while updating....");
			e.printStackTrace();
		}
		return employeeObj;
	}
}
