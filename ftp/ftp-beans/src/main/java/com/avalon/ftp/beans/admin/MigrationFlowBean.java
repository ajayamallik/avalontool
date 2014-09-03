package com.avalon.ftp.beans.admin;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class MigrationFlowBean implements Serializable {

	private static final long serialVersionUID = 3998672430969673737L;

	/* private int migrateid; */

	private long migrateid;
	@NotEmpty(message="Instance id is required")
	private String instanceid;
	@NotEmpty(message="enter sequence name")
	private String sequence;
	@NotEmpty(message="enter approval request ")
	private String appreq;

	/* private String migrationFlowName; */
	@NotEmpty(message="select atleast one value..!!")
	private String migrationflowname;
	@NotEmpty(message="enter migrationflow name")
	private String migrationflow;
	private String userid;
	private String lastupdatetime;

	/*
	 * private MigrationFlowNamesBean migrationFlowNamesBean;
	 * 
	 * public MigrationFlowNamesBean getMigrationFlowNamesBean() { return
	 * migrationFlowNamesBean; }
	 * 
	 * public void setMigrationFlowNamesBean( MigrationFlowNamesBean
	 * migrationFlowNamesBean) { this.migrationFlowNamesBean =
	 * migrationFlowNamesBean; }
	 */

	/*
	 * public int getMigrateid() { return migrateid; }
	 * 
	 * public void setMigrateid(int migrateid) { this.migrateid = migrateid; }
	 */

	public String getInstanceid() {
		return instanceid;
	}

	public long getMigrateid() {
		return migrateid;
	}

	public void setMigrateid(long migrateid) {
		this.migrateid = migrateid;
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

	/*
	 * public String getMigrationFlowName() { return migrationFlowName; }
	 * 
	 * public void setMigrationFlowName(String migrationFlowName) {
	 * this.migrationFlowName = migrationFlowName; }
	 */
	public String getMigrationflow() {
		return migrationflow;
	}

	public String getMigrationflowname() {
		return migrationflowname;
	}

	public void setMigrationflowname(String migrationflowname) {
		this.migrationflowname = migrationflowname;
	}

	public void setMigrationflow(String migrationflow) {
		this.migrationflow = migrationflow;
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
