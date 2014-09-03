package com.avalon.ftp.repository.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.admin.MigrationFlowNamesEntity;

@Repository("migrationFlowNamesRepository")
public class MigrationFlowNamesRepositoryImpl implements
		MigrationFlowNamesRepository {
	protected static final Logger logger = Logger
			.getLogger(MigrationFlowNamesRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public List<MigrationFlowNamesEntity> getMigrationFlowNames() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowNamesRepositoryImpl... executing  createCriteria() and returning to service..");
		return (List<MigrationFlowNamesEntity>) sessionFactory
				.getCurrentSession()
				.createCriteria(MigrationFlowNamesEntity.class).list();
	}

}
