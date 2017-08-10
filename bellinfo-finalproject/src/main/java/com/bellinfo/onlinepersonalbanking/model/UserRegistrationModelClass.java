package com.bellinfo.onlinepersonalbanking.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "registered_user_details")
public class UserRegistrationModelClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name = "accountNumber", nullable = false, length = 11)
	private String accountNumber;
	
	@Column(name = "cifNumber", nullable = false)
	private String cifNumber;
	
	@Column(name = "branchCode", nullable = false)
	private int branchCode;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "salary", nullable = false)
	private int salary;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<TransactionsModelClass> transactions = new ArrayList<TransactionsModelClass>();
	
	
	
	public UserRegistrationModelClass() {
		
	}

	


	public UserRegistrationModelClass(String accountNumber, String cifNumber, int branchCode, String country,
			String phoneNumber, String username, String password, String firstName, String lastName, int salary) {
		this.accountNumber = accountNumber;
		this.cifNumber = cifNumber;
		this.branchCode = branchCode;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary*12;
	}
	
	public List<TransactionsModelClass> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionsModelClass> transactions) {
		this.transactions = transactions;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "UserRegistrationModelClass [id=" + id + ", accountNumber=" + accountNumber + ", cifNumber=" + cifNumber
				+ ", branchCode=" + branchCode + ", country=" + country + ", phoneNumber=" + phoneNumber + ", username="
				+ username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + "]";
	}




	
	

}
