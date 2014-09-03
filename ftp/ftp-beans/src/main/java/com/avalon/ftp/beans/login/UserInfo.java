package com.avalon.ftp.beans.login;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public abstract class UserInfo extends User {
    
    public UserInfo(String username, String password, String userRoleVal, int userRoleIdval, boolean isActive,
            boolean accountNonLocked, List<GrantedAuthority> grantedAuthority) {

        super(username, password, isActive, isActive, isActive, accountNonLocked, grantedAuthority);
        userRole = userRoleVal;
        userRoleId = userRoleIdval;
    }
    
    /** long attribute for holding serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** holds userId of the user. */
    private int userId;
    
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String username;
    
    /** holds userRoleId of the user. */
    private int userRoleId;
    
    /** holds userLevel of the user. */
    private String userRole;
    
    /** holds defaultUserHomeUrl of the user. */
    private String defaultUserHomeUrl;
    
    /**
     * return userId of the Student.
     * 
     * @return the userId
     */
    public int getUserId() {

        return userId;
    }
    
    /**
     * Setter method for userId.
     * 
     * @param userIdVal the userId to set
     */
    public void setUserId(int userIdVal) {

        this.userId = userIdVal;
    }
    
    /**
     * return userRoleId of the Student.
     * 
     * @return the userRoleId
     */
    public int getUserRoleId() {

        return userRoleId;
    }
    
    /**
     * Setter method for userRoleId.
     * 
     * @param userRoleIdVal the userRoleId to set
     */
    public void setUserRoleId(int userRoleIdVal) {

        this.userId = userRoleIdVal;
    }
    
    /**
     * return userRole of the user.
     * 
     * @return the userRole
     */
    public String getRole() {

        return userRole;
    }
    
    /**
     * Setter method for userUserRole.
     * 
     * @param userUserRoleVal the userLevel to set
     */
    public void setRole(String userUserRoleVal) {

        this.userRole = userUserRoleVal;
    }
    
    /**
     * return defaultUserHomeUrl of the user.
     * 
     * @return the defaultUserHomeUrl
     */
    public String getDefaultUserHomeUrl() {

        return defaultUserHomeUrl;
    }
    
    /**
     * Setter defaultUserHomeUrl for the user.
     * 
     * @param defaultUserHomeUrlVal the defaultUserHomeUrl to set
     */
    public void setDefaultUserHomeUrl(String defaultUserHomeUrlVal) {

        this.defaultUserHomeUrl = defaultUserHomeUrlVal;
    }
    
    /**
     * clear method is to dynamic user details.
     */
    public abstract void clear();
    
    /**
     * getUserIdentificationNo to return subjective Id of the respective users.
     * 
     * @return userIdentificationNo.
     */
    public abstract String getUserLevelIdentifier();
    
    /**
     * overridden toString method to represent the UserInfo object.
     * 
     * @return String representation of the userName.
     */
    @Override
    public String toString() {

        return getUsername();
    }
}
