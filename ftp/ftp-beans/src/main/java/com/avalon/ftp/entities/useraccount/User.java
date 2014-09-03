package com.avalon.ftp.entities.useraccount;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class User {
	
	@Id
	@GeneratedValue
	 @Column(name="userid")
	private int userid;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	private int status;
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private String username;
	
	private String userpass;
	
	private String useridd;
	
	
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	 int role_id;
	
	
	
	public String getUseridd() {
		return useridd;
	}

	public void setUseridd(String useridd) {
		this.useridd = useridd;
	}

	private String type;
	
	private Integer empid;
	
	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	private String firstname;
	
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

	private String lastname;
	
	private String email;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="users_role_map",
		joinColumns = {@JoinColumn(name="userid", referencedColumnName="userid")},
	 inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}  
	)
	
	
	
	private Role role;

	
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

