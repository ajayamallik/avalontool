package com.avalon.ftp.beans.login;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1396339078179620956L;

	/*@NotNull(message = "Enter proper username")*/
	@Length( min=4, max = 32, message = "UserName Min 5,Max 32 characters.")
	@NotBlank
	private String username;
	
	/*@NotNull(message = "Enter proper password")*/
	@Length(min=4, max = 15, message = "Password length 8 character Min.")
	@NotBlank
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
