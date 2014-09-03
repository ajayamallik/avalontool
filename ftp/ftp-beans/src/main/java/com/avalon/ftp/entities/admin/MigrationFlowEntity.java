package com.avalon.ftp.entities.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="MigrationFlowEntity")
@Table(name="migrationflow")
public class MigrationFlowEntity {

	@Id
	@GeneratedValue
	@Column(name = "MIGRATEID")
/*	private int migrateid;*/
	private long migrateid;

	@Column(name = "INSTANCEID")
	private String instanceid;

	@Column(name = "SEQUENCE")
	private String sequence;


	@Column(name = "APPROVALREQ")
	private String appreq;

	@Column(name = "MIGRATIONFLOWNAME")
/*	private String migrationFlowName;*/
	private String migrationflowname;

	@Column(name = "USERID")
	private String userid;

	/*public String getMigrationFlowName() {
		return migrationFlowName;
	}

	public void setMigrationFlowName(String migrationFlowName) {
		this.migrationFlowName = migrationFlowName;
	}*/

	@Column(name = "LASTUPDATETIME")
	private String lastupdatetime;

	@Column(name = "MIGRATIONFLOW")
	private String migrationflow;

	/*public int getMigrateid() {
		return migrateid;
	}

	public void setMigrateid(int migrateid) {
		this.migrateid = migrateid;
	}*/


	public long getMigrateid() {
		return migrateid;
	}

	public void setMigrateid(long migrateid) {
		this.migrateid = migrateid;
	}
	public String getInstanceid() {
		return instanceid;
	}

	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getAppreq() {
		return appreq;
	}

	public void setAppreq(String appreq) {
		this.appreq = appreq;
	}

	public String getMigrationflowname() {
		return migrationflowname;
	}

	public void setMigrationflowname(String migrationflowname) {
		this.migrationflowname = migrationflowname;
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

	public String getMigrationflow() {
		return migrationflow;
	}

	public void setMigrationflow(String migrationflow) {
		this.migrationflow = migrationflow;
	}

}
