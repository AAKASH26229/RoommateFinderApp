package com.springrest.roommateapp.entities;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	
	@Column(name="first_name", nullable=false, length=100)
	private String fname;
	
	@Column(name="last_name", nullable=false, length=100)
	private String lname;
	
	@Column(name="gender",  length=100)
	private String gender;
	
	@Column(name="dateofbirth", nullable=false, length=100)
	private String dob;
	
	@Column(name="aadhar", nullable=true, length=100)
	private String aadhar;
	
	@Column(name="city", nullable=false, length=100)
	private String city;
	
	@Column(name="state", nullable=false, length=100)
	private String state;
	
	@Column(name="role", nullable=false, length=100)
	private String role;
	
	@Column(name="email" ,nullable=false, length=100, unique=true)
	private String email;
	
	@Column(name="mobile", nullable=false, length=100)
	private String mobile;
	
	@Column(name="username", nullable=false, length=100)
	private String username;
	
	@Column(name="password", nullable=false, length=100)
	private String password;
	
	@Column(name="diet", length=100)
	private String diet;
	
	@Column(name="shift", nullable=false, length=100)
	private String shift;
	
	@Column(name="occupancy", nullable=false, length=100)
	private String occupancy;
	
	@Column(name="role_user", nullable=false)
	private String role_user;
	
	
	public String getRole_user() {
		return role_user;
	}




	public void setRole_user(String role_user) {
		this.role_user = role_user;
	}



	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="user_roles",
				joinColumns = @JoinColumn(
						name="user_id", referencedColumnName="userid"),
				inverseJoinColumns = @JoinColumn(
						name="role_id" , referencedColumnName="id"))
	private Collection<Role> roles;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Room room;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userid, String fname, String lname, String gender, String dob, String aadhar, String city,
			String state, String role, String email, String mobile, String username, String password, String diet,
			String shift, String occupancy, String role_user, Collection<Role> roles, Room room) {
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
		this.diet = diet;
		this.shift = shift;
		this.occupancy = occupancy;
		this.role_user = role_user;
		this.roles = roles;
		this.room = room;
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




	public String getDiet() {
		return diet;
	}




	public void setDiet(String diet) {
		this.diet = diet;
	}




	public String getShift() {
		return shift;
	}




	public void setShift(String shift) {
		this.shift = shift;
	}




	public String getOccupancy() {
		return occupancy;
	}




	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}




	public Collection<Role> getRoles() {
		return roles;
	}




	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}




	public Room getRoom() {
		return room;
	}




	public void setRoom(Room room) {
		this.room = room;
	}




	@Override
	public String toString() {
		return "User [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", dob="
				+ dob + ", aadhar=" + aadhar + ", city=" + city + ", state=" + state + ", role=" + role + ", email="
				+ email + ", mobile=" + mobile + ", username=" + username + ", password=" + password + ", diet=" + diet
				+ ", shift=" + shift + ", occupancy=" + occupancy + ", role_user=" + role_user + ", roles=" + roles
				+ ", room=" + room + "]";
	}




	
}

