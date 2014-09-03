package com.avalon.ftp.repository.approval;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.entities.approvals.Approval;
import com.avalon.ftp.entities.approvals.ApprovalRequest;
import com.avalon.ftp.entities.environment.EnvironmentEntity;

@Repository
public interface ApprovalRepository {
	public int submitForApproval(Approval approval);
	public List<ApprovalRequest> getPendingApprovals(String status);
	public int saveApprovalRequest(List<ApprovalRequest> podt);
	public int saveApproval(Approval approval);
	public int approvalSubmitted(int appid);
	public List<ApprovalRequest> getApprovedRequests();
	public List<Approval> getMigrationFlow(String appid);
	public MigrationFlowEntity getInstanceId(String migrationflow);
	public EnvironmentEntity getEnvDetails(String instanceid);
	public List<EnvironmentEntity> getInstaceDetails();
	public int changeApprovalStatusToRun(String id);
	public  List<Approval> getInstanceNames(String id);
	public EnvironmentEntity getEnvDetailsByInstanceName(String instaName);
	public String getRequestType(String appId);


}
