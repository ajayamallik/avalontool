package com.avalon.ftp.repository.admin;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.admin.DeploymentEntity;

@Repository("deploymentRepository")
public class DeploymentRepositoryImpl implements DeploymentRepository {
	protected static final Logger logger = Logger
			.getLogger(DeploymentRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	 @Transactional(propagation = Propagation.REQUIRED)
	public long saveDeployment(DeploymentEntity deploymentEntity) {
		// TODO Auto-generated method stub
		logger.info("Entered into @DeploymentRepositoryImpl..."+deploymentEntity.getEnvironmentid());

		long id= (Long) sessionFactory.getCurrentSession().save(deploymentEntity); 
		
		
		logger.info("@DeploymentRepositoryImpl....save() executed..The retured id::"+id+"..."+deploymentEntity.getEnvironmentid());
		return id;
		/*return deploymentEntity.getEnvironmentid();*/
	}
	 @Transactional(propagation = Propagation.REQUIRED)
	public DeploymentEntity getDeploymentByInstanceName(String instancename) {
		// TODO Auto-generated method stub
		 logger.info("@DeploymentRepositoryImpl..getDeploymentByInstanceName(String instancename)");
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DeploymentEntity.class);
		 DeploymentEntity deploymentEntity =  (DeploymentEntity) criteria.add(Restrictions.eq("instancename", instancename)).uniqueResult();
		logger.info("returning from getDeploymentByInstanceName()..");
		return deploymentEntity;
	}


}
