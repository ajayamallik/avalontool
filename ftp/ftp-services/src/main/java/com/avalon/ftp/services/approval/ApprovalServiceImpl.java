package com.avalon.ftp.services.approval;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.beans.approvals.ApprovalBean;
import com.avalon.ftp.beans.approvals.ApprovalRequestBean;
import com.avalon.ftp.beans.environment.EnvironmentBean;
import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.entities.approvals.Approval;
import com.avalon.ftp.entities.approvals.ApprovalRequest;
import com.avalon.ftp.entities.environment.EnvironmentEntity;
import com.avalon.ftp.repository.approval.ApprovalRepository;

@Service("approvalService")
public class ApprovalServiceImpl implements ApprovalService {
	Logger logger = Logger.getLogger(ApprovalServiceImpl.class);

	@Autowired
	ApprovalRepository approvalRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public int submitForApproval(ApprovalBean approvalBean) {
		// TODO Auto-generated method stub
		logger.info("Entered into submitForApproval(ApprovalBean approvalBean) ");
		Approval approval = new Approval();
		approval = createApprovalEntity(approvalBean, approval);
		logger.info("Calling::...approvalRepository.submitForApproval(approval) ");
		return approvalRepository.submitForApproval(approval);
	}

	/**
	 * Constructs an Entity for Approval to persist
	 * 
	 * @param approvalBean
	 * @param approval
	 * @return
	 */
	private Approval createApprovalEntity(ApprovalBean approvalBean,
			Approval approval) {
		approval.setApprovalid(approvalBean.getApprovalid());
		approval.setApprovalstatus(approvalBean.getApprovalstatus());
		approval.setCreatedby(approvalBean.getCreatedby());
		approval.setCreatedon(approvalBean.getCreatedon());
		approval.setGroupp(approvalBean.getGroupp());
		approval.setMigrationflow(approvalBean.getMigrationflow());
		approval.setMigrationtype(approvalBean.getMigrationtype());
		approval.setModified_time(approvalBean.getModified_time());
		approval.setOwnerr(approvalBean.getOwnerr());
		approval.setRequestno(approvalBean.getRequestno());
		approval.setStatuss(approvalBean.getStatuss());
		approval.setUserid(approvalBean.getUserid());

		return approval;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<ApprovalRequestBean> getPendingApprovals(String status) {
		// TODO Auto-generated method stub
		logger.info("@service Entered into getPendingApprovals() and calling::approvalRepository.getPendingApprovals()");
		List<ApprovalRequestBean> approvalRequestBeans = new ArrayList<ApprovalRequestBean>();
		List<ApprovalRequest> approvalRequest = approvalRepository.getPendingApprovals(status);
		logger.info("Checking returned list size::"+approvalRequest.size()+"..."+"Is approvalRequest empty..::"+approvalRequest.isEmpty());
		/*if (approvalRequest != null && approvalRequest.isEmpty()) {*/
		if (approvalRequest != null) {
			logger.info("Entered into if loop..");
			for (ApprovalRequest approvalrequest : approvalRequest) {
				logger.info("Entered into for loop...");
				ApprovalRequestBean bean = new ApprovalRequestBean();
				bean.setApprovalid(approvalrequest.getApprovalid());
				bean.setAppshortname(approvalrequest.getAppshortname());
				bean.setBusinessevent(approvalrequest.getBusinessevent());
				bean.setCntrlfilename(approvalrequest.getCntrlfilename());
				bean.setExecasapps(approvalrequest.getExecasapps());
				bean.setFilename(approvalrequest.getFilename());
				bean.setId(approvalrequest.getId());
				bean.setLanguage(approvalrequest.getLanguage());
				bean.setLobcode(approvalrequest.getLobcode());
				bean.setObjecttype(approvalrequest.getObjecttype());
				bean.setPath(approvalrequest.getPath());
				bean.setStatus(approvalrequest.getStatus());
				bean.setTargetpath(approvalrequest.getTargetpath());
				bean.setTerritory(approvalrequest.getTerritory());
				logger.info("Printing pending values in Service:");
				approvalRequestBeans.add(bean);
			}
		}
		logger.info("returning back to controller");
		return approvalRequestBeans;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveApprovalRequest(List<ApprovalRequest> podt) {
		// TODO Auto-generated method stub
		return approvalRepository.saveApprovalRequest(podt);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveApproval(Approval approval) {
		// TODO Auto-generated method stub
		return approvalRepository.saveApproval(approval);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int approvalSubmitted(int appid) {
		// TODO Auto-generated method stub		
		return approvalRepository.approvalSubmitted(appid);		
	}

	public List<ApprovalRequestBean> approvedRequests() {
		// TODO Auto-generated method stub
		List<ApprovalRequest> approvalRequest = new ArrayList<ApprovalRequest>();
		List<ApprovalRequestBean> approvalReqBean = new ArrayList<ApprovalRequestBean>();
		approvalRequest = approvalRepository.getApprovedRequests();

		
		logger.info("Checking returned list size::"+approvalRequest.size()+"..."+"Is approvalRequest empty..::"+approvalRequest.isEmpty());
		/*if (approvalRequest != null && approvalRequest.isEmpty()) {*/
		if (approvalRequest != null) {			
			for (ApprovalRequest approvalrequest : approvalRequest) {				
				ApprovalRequestBean bean = new ApprovalRequestBean();
				bean.setApprovalid(approvalrequest.getApprovalid());
				bean.setAppshortname(approvalrequest.getAppshortname());
				bean.setBusinessevent(approvalrequest.getBusinessevent());
				bean.setCntrlfilename(approvalrequest.getCntrlfilename());
				bean.setExecasapps(approvalrequest.getExecasapps());
				bean.setFilename(approvalrequest.getFilename());
				bean.setId(approvalrequest.getId());
				bean.setLanguage(approvalrequest.getLanguage());
				bean.setLobcode(approvalrequest.getLobcode());
				bean.setObjecttype(approvalrequest.getObjecttype());
				bean.setPath(approvalrequest.getPath());
				bean.setStatus(approvalrequest.getStatus());
				bean.setTargetpath(approvalrequest.getTargetpath());
				bean.setTerritory(approvalrequest.getTerritory());
				logger.info("Printing pending values in Service:");
				approvalReqBean.add(bean);
			}
		}
		logger.info("returning back to controller");
		return approvalReqBean;
		
		
		
	}

	public List<ApprovalBean> getMigratioFlow(String appid) {
		// TODO Auto-generated method stub
		List<Approval> approvalObj = new ArrayList<Approval>();
		List<ApprovalBean> approvlbeanObj = new ArrayList<ApprovalBean>();
		
		approvalObj =  approvalRepository.getMigrationFlow(appid);
		 for(Approval ap : approvalObj){
			 ApprovalBean apBean = new ApprovalBean();
			 apBean.setApprovalid(ap.getApprovalid());
			 apBean.setApprovalstatus(ap.getApprovalstatus());
			 apBean.setCreatedby(ap.getCreatedby());
			 apBean.setCreatedon(ap.getCreatedon());
			 apBean.setGroupp(ap.getGroupp());
			 apBean.setMigrationflow(ap.getMigrationflow());
			 apBean.setMigrationtype(ap.getMigrationtype());
			 apBean.setModified_time(ap.getModified_time());
			 apBean.setOwnerr(ap.getOwnerr());
			 apBean.setRequestno(ap.getRequestno());
			 apBean.setStatuss(ap.getStatuss());
			 apBean.setUserid(ap.getUserid());
			 approvlbeanObj.add(apBean);
		 }
		return approvlbeanObj;		
	}

	public MigrationFlowBean getInstanceId(String migrationflow) {
		// TODO Auto-generated method stub
		MigrationFlowBean migrationflowbeanObj = new MigrationFlowBean();
		MigrationFlowEntity migrationfloweObj = new MigrationFlowEntity();
		
		migrationfloweObj =  approvalRepository.getInstanceId(migrationflow);
		
		migrationflowbeanObj.setAppreq(migrationfloweObj.getAppreq());
		migrationflowbeanObj.setInstanceid(migrationfloweObj.getInstanceid());
		migrationflowbeanObj.setMigrateid(migrationfloweObj.getMigrateid());
		migrationflowbeanObj.setMigrationflow(migrationfloweObj.getMigrationflow());
		migrationflowbeanObj.setMigrationflowname(migrationfloweObj.getMigrationflow());
		migrationflowbeanObj.setSequence(migrationfloweObj.getSequence());
		migrationflowbeanObj.setUserid(migrationfloweObj.getUserid());
		migrationflowbeanObj.setLastupdatetime(migrationfloweObj.getLastupdatetime());
		 
		return migrationflowbeanObj;	
	}

	public EnvironmentBean getEnvDetails(String instanceid) {
		// TODO Auto-generated method stub
		EnvironmentBean  envBeanObj = new EnvironmentBean();
		EnvironmentEntity envEntityObj = new EnvironmentEntity();
		
		envEntityObj =  approvalRepository.getEnvDetails(instanceid);
		
		envBeanObj.setEnvironmentid(envEntityObj.getEnvironmentid());
		envBeanObj.setHost(envEntityObj.getHost());
		envBeanObj.setInstanceid(envEntityObj.getInstanceid());
		envBeanObj.setInstancename(envEntityObj.getInstancename());
		envBeanObj.setLastupdatetime(envEntityObj.getLastupdatetime());
		envBeanObj.setPort(envEntityObj.getPort());
		envBeanObj.setSid(envEntityObj.getSid());
		envBeanObj.setStatus(envEntityObj.getStatus());
		envBeanObj.setUserid(envEntityObj.getUserid());
		 
		return envBeanObj;
	}
	
	
	// Added on Dt : 28-AUG-2014
	// By Mallik
	// To get instance details to insert in ApprovalForm

	public List<String> getInstanceDetails() {		
		// TODO Auto-generated method stub
		List<EnvironmentEntity> envDetailsEntity = new ArrayList<EnvironmentEntity>();
		List<String> envDetails = new ArrayList<String>();
		envDetailsEntity = approvalRepository.getInstaceDetails();
		 for(EnvironmentEntity ap : envDetailsEntity){			 
			 envDetails.add(ap.getInstancename());
		 }
		return envDetails;
	}

	
	// Added on Dt : 30-AUG-2014
		// By Mallik
		// To change approval request after executing request 
	public int changeApprovalStatusToRun(String id) {
		// TODO Auto-generated method stub
		return approvalRepository.changeApprovalStatusToRun(id);
	}

	public String getInstanceNames(String id) {
		// TODO Auto-generated method stub
		String names = null;
		List<Approval> name = approvalRepository.getInstanceNames(id);
		for(Approval ap : name ){
			if(names != null)
				names += ap.getInstanceids();
			else 
				names = ap.getInstanceids();
		}
		return names;
	}

	public EnvironmentBean getEnvDetailsByInstanceName(String instaName) {
		// TODO Auto-generated method stub
		EnvironmentBean eb = new EnvironmentBean();
		EnvironmentEntity e = new EnvironmentEntity();
		e = approvalRepository.getEnvDetailsByInstanceName(instaName);
		eb.setEnvironmentid(e.getEnvironmentid());
		eb.setHost(e.getHost());
		eb.setInstanceid(e.getInstanceid());
		eb.setInstancename(e.getInstancename());
		eb.setLastupdatetime(e.getLastupdatetime());
		eb.setPort(e.getPort());
		eb.setSid(e.getSid());
		eb.setStatus(e.getStatus());
		eb.setUserid(e.getUserid());
		return eb;
	}

	public String getRequestType(String appId) {
		// TODO Auto-generated method stub
		return approvalRepository.getRequestType(appId);
	}

	public String getCPName(String appid) {
		// TODO Auto-generated method stub
		return approvalRepository.getCPName(appid);
	}

}
