package com.avalon.ftp.repository.admin;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.admin.MigrationFlowEntity;

@Repository("migrationFlowRepository")
public interface MigrationFlowRepository {

	public long saveMigrationFlow(MigrationFlowEntity migrationFlowEntity);

	public MigrationFlowEntity getMigrationFlowByName(String migrationflowname);
}
