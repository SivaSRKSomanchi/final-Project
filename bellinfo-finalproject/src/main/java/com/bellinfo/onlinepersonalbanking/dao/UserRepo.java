package com.bellinfo.onlinepersonalbanking.dao;

import java.util.List;

import com.bellinfo.onlinepersonalbanking.model.TransactionsModelClass;
import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;

public interface UserRepo {

	public void saveUserDetails(UserRegistrationModelClass userReg);

	public boolean checkLogin(String username, String password);

	public UserRegistrationModelClass getUserDetails(String username, String password);

	public UserRegistrationModelClass getCustomer(int id);

	public List<UserRegistrationModelClass> getAllCustomers();

	public List<UserRegistrationModelClass> recipientCustomer(int value, int radioStatus,UserRegistrationModelClass loggedUser);

	public List<TransactionsModelClass> getUsersInvolved(String user);
	 
}
