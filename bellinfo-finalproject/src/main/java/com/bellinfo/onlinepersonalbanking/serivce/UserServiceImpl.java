package com.bellinfo.onlinepersonalbanking.serivce;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bellinfo.onlinepersonalbanking.dao.UserRepo;
import com.bellinfo.onlinepersonalbanking.model.TransactionsModelClass;
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


	@Override
	@Transactional
	public List<TransactionsModelClass> getUsersInvolved(String user) {
		System.out.println("INSIDE SERVICE LAYER - GET USERS INVOLVED IN TRANSACTIOINS METHOD");
		return userRepoDAO.getUsersInvolved(user);
	}


	@Override
	public boolean verify(String otp,String num) {
		System.out.println("INSIDE SERVICE LAYER - Verify OTP METHOD");// TODO Auto-generated method stub
		String generatedOTP = otp(4);
		System.out.println("Generated = "+num+" "+"Entered OTP = "+otp);
		if(otp.equals(num)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String otp(int len) {
		System.out.println("Inside Generating otp");
		String numbers = "0123456789";
		Random r = new Random();
		String o = "";
		char[] otp = new char[len];
		for(int i=0;i<len;i++) {
			otp[i] = numbers.charAt(r.nextInt(numbers.length()));
			o += otp[i];
		}
		return o;
	}

}
