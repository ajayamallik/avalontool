package com.avalon.ftp.beans.user;

import org.hibernate.validator.constraints.NotEmpty;


	public class UserRoleBean {
		
	
		private int role_id;
		private String description;
		
		@NotEmpty(message="Role  is required")
		private String role;		
		private String userid;
		
		
		public int getRole_id() {
			return role_id;
		}

		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
			
		

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}


	}



