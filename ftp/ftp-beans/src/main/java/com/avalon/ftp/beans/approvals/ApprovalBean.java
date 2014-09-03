package com.avalon.ftp.beans.approvals;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class ApprovalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4270812295592271947L;

	private int approvalid;
	@NotEmpty
	private String createdby;
	@NotEmpty
	private String migrationflow;	
	@NotEmpty
	private String createdon;
	@NotEmpty
	private String ownerr;
	@NotEmpty
	private String statuss;
	@NotEmpty
	private String groupp;
	@NotEmpty
	private String migrationtype;

	private String userid;

	private String approvalstatus;

	private String modified_time;
	@NotEmpty
	private String requestno;
	
	public String getInstanceids() {
		return instanceids;
	}

	public void setInstanceids(String instanceids) {
		this.instanceids = instanceids;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@NotEmpty
	private String instanceids;
	
	@NotEmpty
	private String requestType;

	public int getApprovalid() {
		return approvalid;
	}

	public void setApprovalid(int approvalid) {
		this.approvalid = approvalid;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getMigrationflow() {
		return migrationflow;
	}

	public void setMigrationflow(String migrationflow) {
		this.migrationflow = migrationflow;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getOwnerr() {
		return ownerr;
	}

	public void setOwnerr(String ownerr) {
		this.ownerr = ownerr;
	}

	public String getStatuss() {
		return statuss;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public String getGroupp() {
		return groupp;
	}

	public void setGroupp(String groupp) {
		this.groupp = groupp;
	}

	public String getMigrationtype() {
		return migrationtype;
	}

	public void setMigrationtype(String migrationtype) {
		this.migrationtype = migrationtype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getApprovalstatus() {
		return approvalstatus;
	}

	public void setApprovalstatus(String approvalstatus) {
		this.approvalstatus = approvalstatus;
	}

	public String getModified_time() {
		return modified_time;
	}

	public void setModified_time(String modified_time) {
		this.modified_time = modified_time;
	}

	public String getRequestno() {
		return requestno;
	}

	public void setRequestno(String requestno) {
		this.requestno = requestno;
	}

}
