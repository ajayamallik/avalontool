package com.avalon.ftp.beans.admin;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class DeploymentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3311905901031283089L;
	
	
	private long environmentid;
	@NotEmpty
	private String instancename;
	@NotEmpty
	private String port;
	@NotEmpty
	private String host;
	@NotEmpty
	private String sid;
	@NotEmpty
	private String status;
	@NotEmpty
	private String instanceid;

	public long getEnvironmentid() {
		return environmentid;
	}

	public void setEnvironmentid(long environmentid) {
		this.environmentid = environmentid;
	}

	public String getInstancename() {
		return instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
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

}
