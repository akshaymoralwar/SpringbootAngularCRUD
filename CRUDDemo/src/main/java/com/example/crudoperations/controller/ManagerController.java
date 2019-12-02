/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperations.bean.ManagerBean;
import com.example.crudoperations.dao.ManagerDAO;
import com.example.crudoperations.dao.ManagerDAOImpl;
import com.example.crudoperations.security.SecurityFilter;
import com.example.crudoperations.service.ManagerService;

/* Controller class used for URL mapping. REST API.*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	ManagerDAOImpl managerRepository;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private ManagerDAO mangerDao;

	/*
	 * The method will save the data as a record in the database and return an
	 * ManaerBean Object.
	 * 
	 * @param manager
	 * 
	 * @return manager
	 * 
	 */

	@PostMapping("/saveManager")
	public ManagerBean save(@RequestBody ManagerBean manager) {
		System.out.println(manager.toString());
		managerService.save(manager);
		return manager;
	}

	/*
	 * Returns boolean after checking whether the user name and password.
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @return isManager
	 */
	@RequestMapping(value = "/checkIfExists", method = RequestMethod.POST)
	public boolean checkIfExistsInDb(HttpServletRequest request, HttpServletResponse response) {
		SecurityFilter securityFilter = new SecurityFilter();

		String bausername = request.getParameter("email");
		String bapassword = request.getParameter("password");

		System.out.println("Browser sent " + bausername + "  " + bapassword);
		boolean isManager = false;
		isManager = mangerDao.checkIfExistInDb(bausername, bapassword);
		return isManager;
	}
}
