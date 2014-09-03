package com.avalon.ftp.entities.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avalon.ftp.entities.useraccount.Role;



@Entity
@Table(name="role_privilege")
public class Roleprivilege {
   
     
    @Id
    @Column(name="role_privilege_id")
    private int rolePrivilegeId;
    
   
    @Column(name="user_role_id")
    private int user_role_id;
    
    @Column(name="privilege_id",insertable=false,updatable=false)
    private int privilegeId;

    
    private String userid;

    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	
	 @ManyToOne(cascade=CascadeType.ALL)   
		@JoinColumn(name="user_role_id", referencedColumnName="role_id",insertable=false,updatable=false) 
	  	private Role role;
    
    
    @ManyToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="privilege_id", referencedColumnName="privilege_id") 
    private Privilege privilege;
    
    public Roleprivilege() {

    }
    
    public int getRolePrivilegeId() {

        return rolePrivilegeId;
    }
    
       public void setRolePrivilegeId(int rolePrivilegeIdObj) {

        this.rolePrivilegeId = rolePrivilegeIdObj;
    }
    
    public Role getRole() {

        return role;
    }
    
    public void setRole(Role roleobj) {

        this.role = roleobj;
    }
    
    public Privilege getPrivilege() {

        return privilege;
    }
    
    public void setPrivilege(Privilege privilegeObj) {

        this.privilege = privilegeObj;
    }
    
       
}
