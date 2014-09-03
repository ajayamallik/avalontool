package com.avalon.ftp.entities.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_privilege")
public class Rolerprivilege {
	
	
	
	  @Id
	    @Column(name="role_privilege_id")
	    private int rolePrivilegeId;
	    
	   
	    public int getRolePrivilegeId() {
		return rolePrivilegeId;
	}

	public void setRolePrivilegeId(int rolePrivilegeId) {
		this.rolePrivilegeId = rolePrivilegeId;
	}



		@Column(name="user_role_id")
	    private int user_role_id;
	    
	    @Column(name="privilege_id")
	    private int privilegeId;
	    
	    
	    public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		private String userid;
	    
	    public String getModified_time() {
			return modified_time;
		}

		public void setModified_time(String modified_time) {
			this.modified_time = modified_time;
		}

		 @Column(name="modified_time")
		private String modified_time;


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

		
	
}
