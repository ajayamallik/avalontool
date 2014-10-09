package com.avalon.ftp.services.approval;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.beans.approvals.ApprovalBean;
import com.avalon.ftp.beans.approvals.ApprovalRequestBean;
import com.avalon.ftp.beans.environment.EnvironmentBean;
import com.avalon.ftp.entities.approvals.Approval;
import com.avalon.ftp.entities.approvals.ApprovalRequest;

@Service
public interface ApprovalService {
	public int submitForApproval(ApprovalBean approvalBean);
	public List<ApprovalRequestBean> getPendingApprovals(String status);
	public int saveApprovalRequest(List<ApprovalRequest> podt);
	public int saveApproval(Approval approvalBean);
	public int approvalSubmitted(int appid);
	public List<ApprovalRequestBean> approvedRequests();
	public List<ApprovalBean> getMigratioFlow(String string);
	public MigrationFlowBean getInstanceId(String migrationflow);
	public EnvironmentBean getEnvDetails(String instanceid);
	public List<String> getInstanceDetails();
	public int changeApprovalStatusToRun(String string);
	public String getInstanceNames(String id);
	public EnvironmentBean getEnvDetailsByInstanceName(String string);
	public String getRequestType(String appid);
	public String getCPName(String appid);


}
 