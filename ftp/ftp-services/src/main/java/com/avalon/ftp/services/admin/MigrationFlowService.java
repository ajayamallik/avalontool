package com.avalon.ftp.services.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.beans.meta.MigrationFlowMetaBean;
import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;

@Service("migrationFlowService")
public interface MigrationFlowService {
	public long saveMigrationFlow(MigrationFlowBean migrationFlowBean);

	public MigrationFlowBean getMigrationFlowByName(String migrationflowname);
	//merged by mallik
	//implemented by murali
	//Dt: 3-SEP-2014
	public long addNewMigrationFlow(MigrationFlowMetaBean migrationFlowMetaBean);
	public void updateNewMigrationFlow(MigrationFlowMetaBean migrationFlowMetaBean);

	public List<MigrationFlowMetaBean> searchMigrationFlow();
	public MigrationFlowMetaBean editMigrationFlowByID(long migrationFlowId);
	public void deleteMigrationFlowByID(long migrationFlowId);
	public MigrationFlowMetaEntity getMigrationFlowById(long migrationFlowId);
}
