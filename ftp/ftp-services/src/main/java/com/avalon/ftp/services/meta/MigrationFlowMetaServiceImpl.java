package com.avalon.ftp.services.meta;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.entities.meta.MigrationTypeEntity;
import com.avalon.ftp.repository.meta.MigrationFlowMetaRepository;

@Service("migrationFlowMetaService")
public class MigrationFlowMetaServiceImpl implements MigrationFlowMetaService {
	protected static final Logger logger = Logger
			.getLogger(MigrationFlowMetaServiceImpl.class);
	@Autowired
	@Qualifier("migrationFlowMetaRepository")
	MigrationFlowMetaRepository migrationFlowMetaRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<MigrationFlowMetaEntity> getMigrationFlows() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowMetaServiceImpl...calling migrationFlowMetaRepository.getMigrationFlows()");
		List<MigrationFlowMetaEntity> migrationFlows= migrationFlowMetaRepository.getMigrationFlows();
		logger.info("MigrationFlow values ::"+migrationFlows.get(0)+".."+migrationFlows.get(1));
		return migrationFlowMetaRepository.getMigrationFlows();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<MigrationTypeEntity> getMigrationTypeValues() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowMetaServiceImpl calling getMigrationTypeValues()");
		return migrationFlowMetaRepository.getMigrationTypeValues();
	}

}
