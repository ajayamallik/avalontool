package com.avalon.ftp.services.admin;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.admin.DeploymentBean;

@Service("deploymentService")
public interface DeploymentService {
	public long saveDeployment(DeploymentBean deploymentBean);
	public DeploymentBean getDeploymentByInstanceName(String instancename);

}
