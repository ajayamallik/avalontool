package com.avalon.ftp.entities.approvals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
/* 
 ApprovalDforRequest is main table.
  It distributes requests data to  ApprovalRequest POJO
 */

@Entity(name = "Approval")
@Table(name = "approval")
public class Approval {

	@Id
	@GeneratedValue
	@Column(name = "approvalid")
	private int approvalid;

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

	@Column(name = "createdby")
	private String createdby;

	@Column(name = "migrationflow")
	private String migrationflow;

	@Column(name = "createdon")
	private String createdon;

	@Column(name = "ownerr")
	private String ownerr;

	@Column(name = "statuss")
	private String statuss;

	@Column(name = "groupp")
	private String groupp;

	@Column(name = "migrationtype")
	private String migrationtype;

	@Column(name = "userid")
	private String userid;

	@Column(name = "approvalstatus")
	private String approvalstatus;

	@Column(name = "modified_time")
	private String modified_time;

	@Column(name = "requestno")
	private String requestno;
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Column(name ="REQUESTTYPE")
	private String requestType;
	
	public String getInstanceids() {
		return instanceids;
	}

	public void setInstanceids(String instanceids) {
		this.instanceids = instanceids;
	}

	@Column(name = "INSTANCEIDS")
	private String instanceids;
	
	
	@Transient	
	private List<ApprovalRequest> aprovalRequest = LazyList.decorate(new ArrayList<ApprovalRequest>(),FactoryUtils.instantiateFactory(ApprovalRequest.class));
	
	
	public List<ApprovalRequest> getAprovalRequest() {
		return aprovalRequest;
	}

	public void setAprovalRequest(List<ApprovalRequest> aprovalRequest) {
		this.aprovalRequest = aprovalRequest;
	}

	public Approval()
	{}
	
	public Approval(int approvalid,  String  createdby, String migrationflow,String createdon,String ownerr,String statuss,String groupp,String migrationtype,String userid,String approvalstatus,String modified_time,String requestno)
	{
		super();
		this.approvalid = approvalid;
		this.createdby = createdby;
		this.migrationflow = migrationflow;		
		this.createdon = createdon;
		this.ownerr = ownerr;	
		this.statuss = statuss;
		this.groupp =groupp;
		this.migrationtype = migrationtype;
		this.userid = userid;		
		this.approvalstatus = approvalstatus;
		this.modified_time = modified_time;
		this.requestno = requestno;
	}
}
