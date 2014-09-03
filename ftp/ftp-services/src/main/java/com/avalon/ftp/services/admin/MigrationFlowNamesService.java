package com.avalon.ftp.services.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.entities.admin.MigrationFlowNamesEntity;
@Service("migrationFlowNamesService")
public interface MigrationFlowNamesService {
	/*public List<MigrationFlowNamesBean> getMigrationFlowNames();*/
	public List<MigrationFlowNamesEntity> getMigrationFlowNames();
}
