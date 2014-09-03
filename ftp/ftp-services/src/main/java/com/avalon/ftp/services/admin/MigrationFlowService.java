package com.avalon.ftp.services.admin;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.admin.MigrationFlowBean;

@Service("migrationFlowService")
public interface MigrationFlowService {
	public long saveMigrationFlow(MigrationFlowBean migrationFlowBean);

	public MigrationFlowBean getMigrationFlowByName(String migrationflowname);
}
