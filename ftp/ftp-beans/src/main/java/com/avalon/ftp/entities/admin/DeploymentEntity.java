package com.avalon.ftp.entities.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "DeploymentEntity ")
@Table(name = "environment")
public class DeploymentEntity {

	@Id
	@GeneratedValue
	@Column(name = "ENVIRONMENTID")
	//private int environmentid;
	private long environmentid;

	@Column(name = "INSTANCENAME")
	private String instancename;

	@Column(name = "PORT")
	private String port;

	
	@Column(name = "HOST")
	private String host;

	@Column(name = "SID")
	private String sid;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "INSTANCEID")
	private String instanceid;

	@Column(name = "USERID")
	private String userid;

	@Column(name = "LASTUPDATETIME")
	private String lastupdatetime;

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

	/*public int getEnvironmentid() {
		return environmentid;
	}

	public void setEnvironmentid(int environmentid) {
		this.environmentid = environmentid;
	}*/
	public long getEnvironmentid() {
		return environmentid;
	}

	public void setEnvironmentid(long environmentid) {
		this.environmentid = environmentid;
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

}
