package com.avalon.ftp.beans.user;


public class RoleprivilegeBean {
		

		    private int rolePrivilegeId;
			
		    private int user_role_id;		    
		 
		    public int getUser_role_id() {
				return user_role_id;
			}

			public void setUser_role_id(int user_role_id) {
				this.user_role_id = user_role_id;
			}

			private int privilegeId;

			private String userid;
			
			private String modified_time;
		
		   
		    public int getRolePrivilegeId() {
			return rolePrivilegeId;
		}

		public void setRolePrivilegeId(int rolePrivilegeId) {
			this.rolePrivilegeId = rolePrivilegeId;
		}


		    
		    
		    public String getUserid() {
				return userid;
			}

			public void setUserid(String userid) {
				this.userid = userid;
			}

		    
		    
		    
		    
		    public String getModified_time() {
				return modified_time;
			}

			public void setModified_time(String modified_time) {
				this.modified_time = modified_time;
			}

	
		

		    public int getPrivilegeId() {
				return privilegeId;
			}

			public void setPrivilegeId(int privilegeId) {
				this.privilegeId = privilegeId;
			}

			
		
	}


