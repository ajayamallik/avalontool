package com.avalon.ftp.beans.useraccount;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.avalon.ftp.entities.useraccount.Role;

public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2553866372340132355L;

	private int userid;

	private int status;
	@NotBlank/*(message="UserName requires...!!")*/
	private String username;
	@NotBlank/*(message="Password may not be empty..!!")*/
	private String userpass;
	private String useridd;
	private int role_id;
//	@NotBlank(message="please select one value..!!!")
	private String type;
	/*@NotBlank*//*(message="empid requires...!!")*/
	@NotNull
	private Integer empid;
	@NotBlank/*(message="firstname requires...!!")*/
	private String firstname;
	@NotBlank/*(message="lastname requires...!!")*/
	private String lastname;
	@NotEmpty
	@Email
	private String email;
	/*@NotBlank*/
	private Role role;


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUseridd() {
		return useridd;
	}

	public void setUseridd(String useridd) {
		this.useridd = useridd;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "type";
	}
}
