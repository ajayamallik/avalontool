package com.avalon.ftp.repository.approval;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.entities.approvals.Approval;
import com.avalon.ftp.entities.approvals.ApprovalRequest;
import com.avalon.ftp.entities.environment.EnvironmentEntity;

@Repository("approvalRepository")
public class ApprovalRepositoryImpl implements ApprovalRepository {
	Logger logger = Logger.getLogger(ApprovalRepositoryImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED)
	public int submitForApproval(Approval approval) {
		logger.info("Entered into submitForApproval(Approval approval) ");
		// TODO Auto-generated method stub
		approval.setApprovalstatus("P");
		logger.info("Calling...sessionFactory.getCurrentSession().save(approval); ");
		sessionFactory.getCurrentSession().save(approval);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ApprovalRequest> getPendingApprovals(String status) {
		logger.info("@Repository entered into getPendingApprovals()");
		// TODO Auto-generated method stub
		List<ApprovalRequest> approvalList = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ApprovalRequest.class);
		criteria.add(Restrictions.eq("status", status));
		approvalList = criteria.list();
		return approvalList;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveApprovalRequest(List<ApprovalRequest> podt) {
		// TODO Auto-generated method stub
		logger.info("@Entered into repository saveAprovalRequest"+podt.size());
		logger.info("@Entered into repository saveAprovalRequest"+podt);	
		ApprovalRequest pdt = null;
		for(int i=0;i<podt.size();i++){
			pdt = podt.get(i);
			logger.info("Po Number ");
			sessionFactory.getCurrentSession().saveOrUpdate(pdt);
			System.out.println("Record Successfully Saved");	
		}
		logger.info("Record Successfully Saved with PO NUmber");
		return podt.size();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveApproval(Approval approval) {
		// TODO Auto-generated method stub
		logger.info("@Entered into repository saveAproval"+approval);		
		sessionFactory.getCurrentSession().saveOrUpdate(approval);
		logger.info("Record Successfully Saved with PO NUmber");
		return approval.getApprovalid();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int approvalSubmitted(int appid) {
		// TODO Auto-generated method stub
		logger.info("update id is"+appid);
		Query query = sessionFactory.getCurrentSession().createQuery("update ApprovalRequest set STATUS = :status" +
				" where ID = :id");
		query.setParameter("status", "A");
		query.setParameter("id", appid);
		int result = query.executeUpdate();  	
    	logger.info("approved  ");		
		return 1;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ApprovalRequest> getApprovedRequests() {
		// TODO Auto-generated method stub
		logger.info("@Repository entered into getAprovedRequests()");
		List<ApprovalRequest> approvalList = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				ApprovalRequest.class);
		criteria.add(Restrictions.eq("status", "A"));
		approvalList = criteria.list();
		return approvalList;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Approval> getMigrationFlow(String appid) {
		// TODO Auto-generated method stub
		logger.info("@ reposirory"+ appid);
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(Approval.class);		
		cr.add(Restrictions.eq("approvalid",Integer.parseInt(appid)));		
		List<Approval> result=cr.list();
		logger.info("Migration Flow Result"+result);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public MigrationFlowEntity getInstanceId(String migrationflow) {
		// TODO Auto-generated method stub
		logger.info("@ getInstanceId reposirory  "+ migrationflow);
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(MigrationFlowEntity.class);		
		cr.add(Restrictions.eq("migrationflowname",migrationflow));		
		List<MigrationFlowEntity> result=cr.list();
		logger.info("Instance Id  Result "+result);
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public EnvironmentEntity getEnvDetails(String instanceid) {
		// TODO Auto-generated method stub
		logger.info("@ getEnvDetails reposirory  for instace  "+ instanceid);
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(EnvironmentEntity.class);		
		cr.add(Restrictions.eq("instanceid",instanceid));		
		List<EnvironmentEntity> result=cr.list();
		logger.info("Env  Id  Result "+result);
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EnvironmentEntity> getInstaceDetails() {
		// TODO Auto-generated method stub
		logger.info("@Entered into getInstanceDetails() ");
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(EnvironmentEntity.class);		
		List<EnvironmentEntity> result=cr.list();
		logger.info("Env  Id  Result "+result);
		//Converting Entity to List<String>
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int changeApprovalStatusToRun(String id) {
		// TODO Auto-generated method stub
		logger.info("@Entered into changeApprovalStatusToRun() ");
		logger.info("@request id is"+id);
		Query query = sessionFactory.getCurrentSession().createQuery("update ApprovalRequest set STATUS = :status" +
				" where ID = :id");
		query.setParameter("status", "R");
		query.setParameter("id", id);
		int result = query.executeUpdate();  	
    	logger.info("Update Successful  ");		
		return 1;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Approval> getInstanceNames(String id) {
		// TODO Auto-generated method stub
		logger.info("@Entered into getInstanceNames() ");
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(Approval.class);		
		cr.add(Restrictions.eq("approvalid",Integer.parseInt(id)));		
		List<Approval> result=cr.list();
		logger.info("Env  Id  Result "+result);		
		return result;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public EnvironmentEntity getEnvDetailsByInstanceName(String instaName) {
		// TODO Auto-generated method stub
		logger.info("@Entered into getInstanceNames() "+instaName);
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(EnvironmentEntity.class);		
		cr.add(Restrictions.eq("instancename",instaName));		
		List<EnvironmentEntity> result=cr.list();
		return result.get(0);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public String getRequestType(String appId) {
		// TODO Auto-generated method stub
		logger.info("@Entered into getRequestType() ");
		Criteria cr	= sessionFactory.getCurrentSession().createCriteria(Approval.class);		
		cr.add(Restrictions.eq("approvalid",Integer.parseInt(appId)));		
		List<Approval> result=cr.list();
		logger.info("Env  Id  Result "+result.get(0).getRequestType());		
		return result.get(0).getRequestType();
	}

	
	
}
