package com.avalon.ftp.services.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.admin.MigrationFlowNamesEntity;
import com.avalon.ftp.repository.admin.MigrationFlowNamesRepository;

@Service("migrationFlowNamesService")
public class MigrationFlowNamesServiceImpl implements MigrationFlowNamesService {
	
	protected static final Logger logger=Logger.getLogger(MigrationFlowNamesServiceImpl.class);
	@Autowired
	@Qualifier("migrationFlowNamesRepository")
	MigrationFlowNamesRepository migrationFlowNamesRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<MigrationFlowNamesEntity> getMigrationFlowNames() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowNamesServiceImpl...getMigrationFlowNames()");
		
				return migrationFlowNamesRepository.getMigrationFlowNames();
	
	}
	
	/*@Transactional(propagation=Propagation.REQUIRED)
	public List<MigrationFlowNamesBean> getMigrationFlowNames() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowNamesServiceImpl...getMigrationFlowNames()");
		List<MigrationFlowNamesBean> migrationFlowNamesBeans = new ArrayList<MigrationFlowNamesBean>();
		List<MigrationFlowNamesEntity> migrationFlowNamesEntities = migrationFlowNamesRepository
				.getMigrationFlowNames();
		//null checking
		if (migrationFlowNamesEntities != null) {
			MigrationFlowNamesBean bean = null;
			
			for (MigrationFlowNamesEntity entity : migrationFlowNamesEntities) {
				logger.info("Entered into for loop");
				bean = new MigrationFlowNamesBean();
				bean.setMigId(entity.getMigId());
				bean.setMigrationFlowName(entity.getMigrationFlowName());
				migrationFlowNamesBeans.add(bean);

			}

		}
		logger.info("returning from @MigrationFlowNamesServiceImpl..");
		return migrationFlowNamesBeans;
	}*/

}
