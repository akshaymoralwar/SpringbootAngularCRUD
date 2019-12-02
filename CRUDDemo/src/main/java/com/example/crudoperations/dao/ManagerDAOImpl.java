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

import com.example.crudoperations.bean.ManagerBean;

/*Implementation of ManagerDAO interface.*/
@Repository
public class ManagerDAOImpl implements ManagerDAO {
	@Autowired
	private EntityManager entityManager;

	/*
	 * Returns boolean value for username and password.
	 * 
	 * @param username
	 * 
	 * @param password
	 * 
	 * @return boolean
	 */
	@Override
	public boolean checkIfExistInDb(String username, String password) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from ManagerBean where email = :e and password =:p");
		query.setParameter("e", username);
		query.setParameter("p", password);
		List list = query.list();
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Return list of all managers
	 * 
	 * @return mngrList
	 */
	@Override
	public List<ManagerBean> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ManagerBean> query = currentSession.createQuery("from ManagerBean", ManagerBean.class);
		List<ManagerBean> mngrList = query.getResultList();
		return mngrList;
	}

	/*
	 * Save the record in the database.
	 * 
	 * @param manager
	 */
	@Override
	public void save(ManagerBean manager) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(manager);
	}

}
