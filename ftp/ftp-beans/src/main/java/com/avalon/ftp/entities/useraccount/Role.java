/**
 * 
 */
/**
 * @author Avlon
 *
 */
package com.avalon.ftp.entities.useraccount;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class Role {
	
	@Id
	@GeneratedValue
	private Integer role_id;
	
	private String role;
	
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="users_role_map", 
		joinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}
	
	)
	private Set<User> userRoles;

	public Integer getRole_Id() {
		return role_id;
	}

	public void setRole_Id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	}
	
}
