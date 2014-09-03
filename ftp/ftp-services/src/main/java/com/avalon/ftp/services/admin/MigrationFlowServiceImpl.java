package com.avalon.ftp.services.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.repository.admin.MigrationFlowRepository;

@Service("migrationFlowService")
public class MigrationFlowServiceImpl implements MigrationFlowService {
	
	Logger logger=Logger.getLogger(MigrationFlowServiceImpl.class);
	@Autowired
	@Qualifier("migrationFlowRepository")
	MigrationFlowRepository migrationFlowRepository;
	@Transactional(propagation=Propagation.REQUIRED)
	public long saveMigrationFlow(MigrationFlowBean migrationFlowBean) {
		logger.info("@ MigrationFlowServiceImpl...control enterd into saveMigrationFlow()");
		// TODO Auto-generated method stub
		MigrationFlowEntity migrationFlowEntity = new MigrationFlowEntity();
		migrationFlowEntity.setMigrationflowname(migrationFlowBean.getMigrationflowname());
		migrationFlowEntity.setSequence(migrationFlowBean.getSequence());
		migrationFlowEntity.setInstanceid(migrationFlowBean.getInstanceid());
		migrationFlowEntity.setAppreq(migrationFlowBean.getAppreq());
		migrationFlowEntity.setMigrationflow(migrationFlowBean.getMigrationflow());
		return migrationFlowRepository.saveMigrationFlow(migrationFlowEntity);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public MigrationFlowBean getMigrationFlowByName(String migrationflowname) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl...gethMigrationFlowByName()");
		MigrationFlowEntity migrationFlowEntitytity = migrationFlowRepository.getMigrationFlowByName(migrationflowname);
		MigrationFlowBean migrationFlowBean=new MigrationFlowBean();
		migrationFlowBean.setMigrationflowname(migrationFlowEntitytity.getMigrationflowname());
		migrationFlowBean.setSequence(migrationFlowEntitytity.getSequence());
		migrationFlowBean.setInstanceid(migrationFlowEntitytity.getInstanceid());
		migrationFlowBean.setMigrationflow(migrationFlowEntitytity.getMigrationflow());
		migrationFlowBean.setAppreq(migrationFlowEntitytity.getAppreq());
		return migrationFlowBean;
	}

}
