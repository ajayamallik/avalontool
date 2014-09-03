package com.avalon.ftp.beans.login;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1396339078179620956L;

	@NotNull(message = "Enter proper username")
	private String username;
	@NotNull(message = "Enter proper password")
	private String password;

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
