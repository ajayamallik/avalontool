package com.avalon.ftp.repository.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;

@Repository("migrationFlowRepository")
public interface MigrationFlowRepository {

	public long saveMigrationFlow(MigrationFlowEntity migrationFlowEntity);

	public MigrationFlowEntity getMigrationFlowByName(String migrationflowname);
	
	public long addNewMigrationFlow(
			MigrationFlowMetaEntity migrationFlowMetaEntity);
	public void updateNewMigrationFlow(
			MigrationFlowMetaEntity migrationFlowMetaEntity);


	public List<MigrationFlowMetaEntity> searchMigrationFlow();
	public MigrationFlowMetaEntity getMigrationFlowById(long migrationFlowId);

	public MigrationFlowMetaEntity editMigrationFlowByID(long migrationFlowId);
	public void deleteMigrationFlowByID(long migrationFlowId);
}
