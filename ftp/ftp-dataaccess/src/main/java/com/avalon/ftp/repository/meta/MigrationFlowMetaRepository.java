package com.avalon.ftp.repository.meta;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.entities.meta.MigrationTypeEntity;

@Repository("migrationFlowMetaRepository")
public interface MigrationFlowMetaRepository {
	public List<MigrationFlowMetaEntity> getMigrationFlows();

	public List<MigrationTypeEntity> getMigrationTypeValues();

}
