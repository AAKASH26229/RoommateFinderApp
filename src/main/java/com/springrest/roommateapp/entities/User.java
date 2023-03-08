package com.springrest.roommateapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;
	
	@Column(name="first_name", nullable=false, length=100)
	private String fname;
	
	@Column(name="last_name", nullable=false, length=100)
	private String lname;
	
	@Column(name="gender", nullable=false, length=100)
	private String gender;
	
	@Column(name="dateofbirth", nullable=false, length=100)
	private String dob;
	
	@Column(name="aadhar", nullable=false, length=100)
	private String aadhar;
	
	@Column(name="city", nullable=false, length=100)
	private String city;
	
	@Column(name="state", nullable=false, length=100)
	private String state;
	
	@Column(name="role", nullable=false, length=100)
	private String role;
	
	@Column(name="email" ,nullable=false, length=100)
	private String email;
	
	@Column(name="mobile", nullable=false, length=100)
	private String mobile;
	
	@Column(name="username", nullable=false, length=100)
	private String username;
	
	@Column(name="password", nullable=false, length=100)
	private String password;
	
	
	public User(long userid, String fname, String lname, String gender, String dob, String aadhar, String city,
			String state, String role, String email, String mobile, String username, String password) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.aadhar = aadhar;
		this.city = city;
		this.state = state;
		this.role = role;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
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


	@Override
	public String toString() {
		return "User [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", dob="
				+ dob + ", aadhar=" + aadhar + ", city=" + city + ", state=" + state + ", role=" + role + ", email="
				+ email + ", mobile=" + mobile + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	

}

