package com.bellinfo.onlinepersonalbanking.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bellinfo.onlinepersonalbanking.model.TransactionsModelClass;
import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUserDetails(UserRegistrationModelClass userReg) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(userReg);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		System.out.println("DAO class -- In Check login");
		Session session = sessionFactory.getCurrentSession();
		boolean userexists = false;
		/*
		 * String SQL_QUERY
		 * =" from UserRegistrationModelClass as o where o.username=? and o.password=?";
		 * Query query = session.createQuery(SQL_QUERY); query.setParameter(0,username);
		 * query.setParameter(1,password);
		 */

		Criteria c = session.createCriteria(UserRegistrationModelClass.class);
		Criterion cr = Restrictions.eq("username", username);
		Criterion cr1 = Restrictions.eq("password", password);
		c.add(cr);
		c.add(cr1);
		UserRegistrationModelClass s = (UserRegistrationModelClass) c.uniqueResult();
		System.out.println(s);
		List list = c.list();
		for (Object l : list) {
			System.out.println("in check login" + l.toString());
		}

		if ((list != null) && (list.size() > 0)) {
			userexists = true;
		}
		return userexists;
	}

	@Override
	public UserRegistrationModelClass getUserDetails(String username, String password) {
		System.out.println(username + " " + password);
		System.out.println("DAO class -- In get user details method");
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(UserRegistrationModelClass.class);
		Criterion cr = Restrictions.eq("username", username);
		Criterion cr1 = Restrictions.eq("password", password);
		c.add(cr);
		c.add(cr1);
		UserRegistrationModelClass s = (UserRegistrationModelClass) c.uniqueResult();
		System.out.println("\nDETAILS METOHD: " + s);
		return s;
	}

	@Override
	public UserRegistrationModelClass getCustomer(int id) {
		System.out.println("INSIDE DAO LAYER - GET CUSTOMER WITH ID");
		// get current session
		Session session = sessionFactory.getCurrentSession();
		// Retrieve from the db
		Criteria c = session.createCriteria(UserRegistrationModelClass.class);
		Criterion cr = Restrictions.eq("id", id);
		c.add(cr);
		UserRegistrationModelClass user = (UserRegistrationModelClass) c.uniqueResult();

		/*
		 * Can retrieve like this also : UserRegistrationModelClass user =
		 * session.get(UserRegistrationModelClass.class,id);
		 */

		System.out.println("INSIDE DAO LAYER - GET CUSTOMER WITH ID**\n " + user);
		return user;

	}

	@Override
	public List<UserRegistrationModelClass> getAllCustomers() {
		// get current session
		Session session = sessionFactory.getCurrentSession();
		// Retrieve from db
		Criteria c = session.createCriteria(UserRegistrationModelClass.class);
		List<UserRegistrationModelClass> custList = c.list();
		for (UserRegistrationModelClass s : custList) {
			System.out.println(s);
		}
		return custList;
	}

	@Override
	public List<UserRegistrationModelClass> recipientCustomer(int value, int radioStatus,
			UserRegistrationModelClass loggedUser) {
		// get the current session
		Session session = sessionFactory.getCurrentSession();
		//Creating List of Users and add payer and recipient to that list
		List<UserRegistrationModelClass> transactionUserList = new ArrayList<UserRegistrationModelClass>();
		// retrieve from db
		try {
			
			// Recipient Update
			UserRegistrationModelClass user = session.get(UserRegistrationModelClass.class, radioStatus);
			int currentSal = user.getSalary();
			System.out.println("INSIDE DAO RECIPIENT CUSTOMER METHOD: Recipient currentSal = " + currentSal);
			int updateSal = currentSal + value;
			System.out.println("INSIDE DAO RECIPIENT CUSTOMER METHOD: Recipient updateSal = " + updateSal);
			user.setSalary(updateSal);
			session.saveOrUpdate(user);
			
			// Payer Update
			UserRegistrationModelClass user1 = session.get(UserRegistrationModelClass.class, loggedUser.getId());
			int currentSal1 = user1.getSalary();
			System.out.println("INSIDE DAO RECIPIENT CUSTOMER METHOD: Payer currentSal = " + currentSal);
			int updateSal1 = currentSal1 - value;
			System.out.println("INSIDE DAO RECIPIENT CUSTOMER METHOD: Payer updateSal = " + updateSal1);
			user1.setSalary(updateSal1);
			session.saveOrUpdate(user1);
			
			//Entering Transferr Info into Transaction Table..
			String recipientName = user.getUsername();
			String payerName = user1.getUsername();
			TransactionsModelClass trans = new TransactionsModelClass("Transferred", recipientName, payerName, value, user.getAccountNumber(), user1.getAccountNumber());
			session.save(trans);
			user1.getTransactions().add(trans);
			
			//Adding user and user1 to transactionUserList
			transactionUserList.add(user);
			transactionUserList.add(user1);

		} catch (Exception e) {
			System.out.println(e);
		}
		return transactionUserList;
	}

	@Override
	public List<TransactionsModelClass> getUsersInvolved(String user) {
		System.out.println(user + " Inside DAO LAYER-getUsersInvolved");
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(TransactionsModelClass.class);
		Criterion cr = Restrictions.eq("payer", user);
		c.add(cr);
		List<TransactionsModelClass> s = c.list();
		System.out.println("\nDETAILS METOHD: " + s);
		return s;
	}
	
	
	

	
}
