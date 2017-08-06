package com.bellinfo.onlinepersonalbanking.serivce;

import java.util.List;

import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;

public interface UserService {

	public void saveUserDetails(UserRegistrationModelClass userReg);

	public boolean checkLogin(String username, String password);

	public UserRegistrationModelClass getUserDetails(String username, String password);

	public UserRegistrationModelClass getCustomer(int id);

	public List<UserRegistrationModelClass> getAllCustomers();

	public List<UserRegistrationModelClass> recipientCustomer(int value, int radioStatus, UserRegistrationModelClass loggedUser);
	
}
