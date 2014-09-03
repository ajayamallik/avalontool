package com.avalon.ftp.entities.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Login")
//@Table(name = "login")
@Table(name = "custom_login")
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5342207401213614125L;

	@Id
	@GeneratedValue
	//@Column(name = "login_id")
	@Column(name = "cl_id")
	private Long id;

	@Column(name = "username", updatable = true, nullable = true)
	private String username;

	@Column(name = "password", updatable = true, nullable = true)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
