package com.avalon.ftp.beans.login;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AdminDetails extends UserInfo {
    
    /** String attribute for registration no. */
    private static final String REGISTRATION_NO = ", registrationNo=";
    
    /** String attribute for registration no. */
    private static final String USER_NAME = ", username=";
    
    private  static final String USER_ROLE = ", userrole=";
  
    
    /** String attribute for staff member id. */
    private static final String STAFF_MEMBER_ID = ", searchStaffMemberId=";
    
    /** String attribute for student id. */
    private static final String STUDENT_ID = "AdminDetails-->searchStudentId=";
    
    /** long attribute for holding serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** holds studentId return from student search. */
    private int searchStudentId;
    
    /** holds staffMemberId return from staff search. */
    private int searchStaffMemberId;
    
    /** holds the registrationNo of the staff member. */
    private String registrationNo;
    
    public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

private String userrole;
   
	private String username;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * Instantiates a new admin details.
     * 
     * @param userName the user name
     * @param password the password
     * @param userRole the user role
     * @param userRoleIdval - user userRoleId.
     * @param registrationNoVal the registration no val
     * @param isActive the is active
     * @param accountNonLocked the account non locked
     * @param grantedAuthority the granted authority
     */
	
	
    public AdminDetails(String userName, String password, String userRole, int userRoleIdval, String registrationNoVal,
            boolean isActive, boolean accountNonLocked, List<GrantedAuthority> grantedAuthority) {

        super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);
        
        registrationNo = registrationNoVal;
        
        username=userName;
        
        userrole=userRole;
    }
    
    /**
     * Returns the details for the AdminDetails object.
     * 
     * @return - the AdminDetails object details.
     */
    @Override
    public String toString() {

        return userrole+ USER_NAME + username + STUDENT_ID + searchStudentId + STAFF_MEMBER_ID + searchStaffMemberId + REGISTRATION_NO + registrationNo;
    }
    
    /**
     * return searchStudentId of the Student.
     * 
     * @return the searchStudentId
     */
    public int getSearchStudentId() {

        return searchStudentId;
    }
    
    /**
     * Setter method for searchStudentId.
     * 
     * @param searchStudentIdVal the searchStudentId to set
     */
    public void setSearchStudentId(int searchStudentIdVal) {

        this.searchStudentId = searchStudentIdVal;
    }
    
    /**
     * return searchStaffMemberId of the Student.
     * 
     * @return the searchStaffMemberId
     */
    public int getSearchStaffMemberId() {

        return searchStaffMemberId;
    }
    
    /**
     * Setter method for searchStaffMemberId.
     * 
     * @param searchStaffMemberIdVal the searchStaffMemberId to set
     */
    public void setSearchStaffMemberId(int searchStaffMemberIdVal) {

        this.searchStaffMemberId = searchStaffMemberIdVal;
    }
    
    /**
     * return registrationNo of the Student.
     * 
     * @return the registrationNo
     */
    public String getRegistrationNo() {

        return registrationNo;
    }
    
    /**
     * Setter method for registrationNo.
     * 
     * @param registrationNoVal the registrationNo to set
     */
    public void setRegistrationNo(String registrationNoVal) {

        this.registrationNo = registrationNoVal;
    }
    
    /**
     * method is to clear Student related dynamic attributes.
     */
    @Override
    public void clear() {

        searchStaffMemberId = 0;
        searchStudentId = 0;
        
    }
    
    /**
     * registrationNo for the admin user.
     * 
     * @return registrationNo - registrationNo.
     */
    @Override
    public String getUserLevelIdentifier() {

        return registrationNo;
    }
    
}
