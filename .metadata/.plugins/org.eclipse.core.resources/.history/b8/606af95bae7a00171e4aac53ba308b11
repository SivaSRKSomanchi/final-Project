package com.bellinfo.onlinepersonalbanking.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bellinfo.onlinepersonalbanking.dao.UserRepo;
import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepoDAO;
	
	@Transactional
	public void saveUserDetails(UserRegistrationModelClass userReg) {
		userRepoDAO.saveUserDetails(userReg);
	}

	
	@Transactional
	public boolean checkLogin(String username, String password) {
		System.out.println("In Service class...Check Login");
		return userRepoDAO.checkLogin(username,password);
	}


	@Override
	@Transactional
	public UserRegistrationModelClass getUserDetails(String username, String password) {
		System.out.println("In Service class...get user details method");
		return userRepoDAO.getUserDetails(username,password);
	}


	@Override
	@Transactional
	public UserRegistrationModelClass getCustomer(int id) {
		System.out.println("INSIDE SERVICE LAYER - GET CUSTOMER WITH ID");
		return userRepoDAO.getCustomer(id);
	}


	@Override
	@Transactional
	public List<UserRegistrationModelClass> getAllCustomers() {
		System.out.println("INSIDE SERVICE LAYER - GET ALL CUSTOMERs METHOD");
		return userRepoDAO.getAllCustomers();
	}


	@Override
	@Transactional
	public List<UserRegistrationModelClass> recipientCustomer(int value, int radioStatus, UserRegistrationModelClass loggedUser) {
		System.out.println("INSIDE SERVICE LAYER - GET RECIPIENT CUSTOMER DETAILS METHOD");
		
		return userRepoDAO.recipientCustomer(value,radioStatus,loggedUser);
	}

}
