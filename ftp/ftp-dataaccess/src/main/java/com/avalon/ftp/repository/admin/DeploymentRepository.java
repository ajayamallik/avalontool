package com.avalon.ftp.repository.admin;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.admin.DeploymentEntity;

@Repository("deploymentRepository")
public interface DeploymentRepository {
	public long saveDeployment(DeploymentEntity deploymentEntity);
	public DeploymentEntity getDeploymentByInstanceName(String instancename);

}
