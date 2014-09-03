package com.avalon.ftp.repository.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.admin.MigrationFlowNamesEntity;

@Repository("migrationFlowNamesRepository")
public interface MigrationFlowNamesRepository {

	public List<MigrationFlowNamesEntity> getMigrationFlowNames();
}

