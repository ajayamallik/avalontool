package com.avalon.ftp.beans.environment;

import java.io.Serializable;

public class EnvironmentBean implements Serializable {
	
	/**
	 * 
	 */
	private int environmentid;
	public int getEnvironmentid() {
		return environmentid;
	}
	public void setEnvironmentid(int environmentid) {
		this.environmentid = environmentid;
	}
	public String getInstancename() {
		return instancename;
	}
	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInstanceid() {
		return instanceid;
	}
	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	private String instancename;
	private String host;
	private String port;
	private String sid;
	private String status;
	private String instanceid;
	private String userid;
	private String lastupdatetime;

}
