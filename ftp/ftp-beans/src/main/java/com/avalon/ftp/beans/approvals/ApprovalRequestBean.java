package com.avalon.ftp.beans.approvals;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ApprovalRequestBean implements Serializable{
	/*
	  Bean for ApprovalRequest Entity. Using to get, update pending approvals
	 */
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getObjecttype() {
			return objecttype;
		}

		public void setObjecttype(String objecttype) {
			this.objecttype = objecttype;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public String getAppshortname() {
			return appshortname;
		}

		public void setAppshortname(String appshortname) {
			this.appshortname = appshortname;
		}

		
		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
		
		
		public int getApprovalid() {
			return approvalid;
		}

		public void setApprovalid(int approvalid) {
			this.approvalid = approvalid;
		}
		
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}






	    private String id;
		
	
		private String objecttype;
		
	
		private String filename;
		
	
		private String appshortname;
		


		private String path;


		private int approvalid;	



		private String status;
		
		

		private String lobcode;
		
		private String language;
		
	
		private String territory;
		

		private String execasapps;
		

		private String targetpath;
		

		private String businessevent;
		

		private String cntrlfilename;
		
		private String requesttype;
		
		
		
		public String getRequesttype() {
			return requesttype;
		}

		public void setRequesttype(String requesttype) {
			this.requesttype = requesttype;
		}

		public String getLobcode() {
			return lobcode;
		}

		public void setLobcode(String lobcode) {
			this.lobcode = lobcode;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getTerritory() {
			return territory;
		}

		public void setTerritory(String territory) {
			this.territory = territory;
		}

		public String getExecasapps() {
			return execasapps;
		}

		public void setExecasapps(String execasapps) {
			this.execasapps = execasapps;
		}

		public String getTargetpath() {
			return targetpath;
		}

		public void setTargetpath(String targetpath) {
			this.targetpath = targetpath;
		}

		public String getBusinessevent() {
			return businessevent;
		}

		public void setBusinessevent(String businessevent) {
			this.businessevent = businessevent;
		}

		public String getCntrlfilename() {
			return cntrlfilename;
		}

		public void setCntrlfilename(String cntrlfilename) {
			this.cntrlfilename = cntrlfilename;
		}



		
}
