/**
 * 
 */
/**
 * @author Avlon
 *
 */
package com.avalon.ftp.beans.useraccount;

import java.util.Set;

import com.avalon.ftp.entities.useraccount.User;



public class RoleBean {
	

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
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

	public Set<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	}

	private Integer role_id;
	
	private String role;
	
	
	private String description;
	
	private Set<User> userRoles;

	
}
