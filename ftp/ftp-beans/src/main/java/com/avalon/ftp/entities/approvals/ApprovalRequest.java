package com.avalon.ftp.entities.approvals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
/*
  ApprovalRequest is using to store requests list entered in approvalform.
  Main data is stored using ApprovalDforReq POJO.
  Based on RequestNo it stores data in this POJO.
 */
@Entity
@Table(name = "approvalrequest")
public class ApprovalRequest {
	
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





	@Id       
    @Column(name = "ID")
    @GeneratedValue
    private String id;
	
	@Column(name="OBJECTTYPE")
	private String objecttype;
	
	@Column(name="FILENAME")
	private String filename;
	
	@Column(name="APPSHORTNAME")
	private String appshortname;

	@Column(name="PATH")
	@Lob
	private String path;


	@Column(name="APPROVALID")
	private int approvalid;	


	@Column(name="STATUS")
	private String status;
	
	//NEWLY ADDED FIELDS
	@Column(name="LOBCODE")
	private String lobcode;
	
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



	@Column(name="LANGUAGE")
	private String language;
	
	@Column(name="TERRITORY")
	private String territory;
	
	@Column(name="EXECASAPPS")
	private String execasapps;
	
	@Column(name="TARGETPATH")
	private String targetpath;
	
	@Column(name="BUSINESSEVENT")
	private String businessevent;
	
	@Column(name="CNTRLFILENAME")
	private String cntrlfilename;
	
	
	public String getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}





	@Column(name="REQUESTTYPE")
	private String requesttype;
	//ADDED FIELDS END
	
	public ApprovalRequest()
	{
	}
	
	public ApprovalRequest(String id, String objecttype, String  filename,String appshortname, String path, String lobcode
			,String language,String territory,String execasapps,String targetpath,String businessevent,String cntrlfilename,String status,
			String requesttype)
	{
		super();
		this.id = id;
		this.objecttype = objecttype;
		this.filename = filename;		
		this.appshortname = appshortname;
		this.path = path;
		
		this.lobcode = lobcode;
		this.language = language;
		this.territory = territory;
		this.execasapps = execasapps;
		this.targetpath = targetpath;
		this.businessevent = businessevent;
		this.cntrlfilename = cntrlfilename;
		this.status = status;
		this.requesttype = requesttype;
	}	
}
