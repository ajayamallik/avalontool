package com.avalon.ftp.services.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.admin.DeploymentBean;
import com.avalon.ftp.entities.admin.DeploymentEntity;
import com.avalon.ftp.repository.admin.DeploymentRepository;

@Service("deploymentService")
public class DeploymentServiceImpl implements DeploymentService {
	private static final Logger logger = Logger
			.getLogger(DeploymentServiceImpl.class);
	@Autowired
	@Qualifier("deploymentRepository")
	private DeploymentRepository deploymentRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public long saveDeployment(DeploymentBean deploymentBean) {
		// TODO Auto-generated method stub
		logger.info("@Entered into DeploymentServiceImpl");
		logger.info(" form submitted values::"
				+ deploymentBean.getInstancename() + "..."
				+ deploymentBean.getHost() + ".." + deploymentBean.getPort()
				+ ".." + deploymentBean.getSid());
		DeploymentEntity deploymentEntity = new DeploymentEntity();

		deploymentEntity.setInstancename(deploymentBean.getInstancename());
		deploymentEntity.setHost(deploymentBean.getHost());
		deploymentEntity.setPort(deploymentBean.getPort());
		deploymentEntity.setSid(deploymentBean.getSid());
		deploymentEntity.setStatus(deploymentBean.getStatus());
		deploymentEntity.setInstanceid(deploymentBean.getInstanceid());
		logger.info("calling dao's....deploymentRepository.saveDeployment(deploymentEntity) ");

		return deploymentRepository.saveDeployment(deploymentEntity);

	}
	@Transactional(propagation=Propagation.REQUIRED)
	public DeploymentBean getDeploymentByInstanceName(String instancename) {
		// TODO Auto-generated method stub
		logger.info("@DeploymentServiceImpl..getDeploymentByInstanceName().");
		DeploymentBean deploymentBean =new DeploymentBean();;
		DeploymentEntity deploymentEntity = deploymentRepository.getDeploymentByInstanceName(instancename);
		deploymentBean.setInstancename(deploymentEntity.getInstancename());
		deploymentBean.setHost(deploymentEntity.getHost());
		deploymentBean.setPort(deploymentEntity.getPort());
		deploymentBean.setSid(deploymentEntity.getSid());
		deploymentBean.setStatus(deploymentEntity.getStatus());
		deploymentBean.setInstanceid(deploymentEntity.getInstanceid());
		logger.info("@DeploymentServiceImpl..returning form...getDeploymentByInstanceName().");
		return deploymentBean;
	}

}
