package com.avalon.ftp.services.meta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.entities.meta.MigrationTypeEntity;

@Service("migrationFlowMetaService")
public interface MigrationFlowMetaService {
	public List<MigrationFlowMetaEntity> getMigrationFlows();
	
	public List<MigrationTypeEntity> getMigrationTypeValues();

}
