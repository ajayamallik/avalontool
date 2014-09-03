package com.avalon.ftp.entities.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRole {
	
	@Id	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "role")
	private String role;
	
	
	private String userid;
	
	
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 


}


