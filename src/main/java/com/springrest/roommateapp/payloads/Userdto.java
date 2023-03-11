package com.springrest.roommateapp.payloads;



import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Userdto {

	private long userid;
	
	@NotEmpty
	@Size(min=4, message="First name should have minimum 4 characters")
	private String fname;
	@NotEmpty
	@Size(min=4, message="Last name should have minimum 4 characters")
	private String lname;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String dob;
	@NotEmpty
	private String aadhar;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String role;
	@Email(message="Email address is not valid")
	private String email;
	@NotEmpty
	private String mobile;
	@NotEmpty
	@Size(min=4,max=10, message="Username must be minimum of 4 characters and maximum of 10 characters")
	private String username;
	@NotEmpty
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}$",message="Password must have at least 8 characters and at most 20 characters in combination of atleast 1 digit(0-9), 1 uppercase aphlabet(A-Z), 1 lowercase alphabet(a-z) and 1 special character ")
	private String password;
	
	@NotEmpty
	private String shift;
	
	@NotEmpty
	private String diet;
	
	@NotEmpty
	private String occupancy;
	
	public Userdto() {
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

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	
	
}
