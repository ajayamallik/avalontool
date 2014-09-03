package com.avalon.ftp.repository.meta;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.entities.meta.MigrationTypeEntity;

@Repository("migrationFlowMetaRepository")
public class MigrationFlowMetaRepositoryImpl implements
		MigrationFlowMetaRepository {

	protected static final Logger logger = Logger
			.getLogger(MigrationFlowMetaRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<MigrationFlowMetaEntity> getMigrationFlows() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowMetaRepositoryImpl.. executing  createCriteria() and returning to service..");
		return sessionFactory.getCurrentSession()
				.createCriteria(MigrationFlowMetaEntity.class).list();

	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<MigrationTypeEntity> getMigrationTypeValues() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowMetaRepositoryImpl.. getMigrationTypeValues()...!!");
		return (List<MigrationTypeEntity>) sessionFactory.getCurrentSession()
				.createCriteria(MigrationTypeEntity.class).list();

	}

}
