package com.avalon.ftp.repository.admin;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.admin.MigrationFlowEntity;

@Repository("migrationFlowRepository")
public class MigrationFlowRepositoryImpl implements MigrationFlowRepository {
	Logger logger=Logger.getLogger(MigrationFlowRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED)
	public long saveMigrationFlow(MigrationFlowEntity migrationFlowEntity) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl control entered into MigrationFlowRepositoryImpl() ..calling save()");
		return (Long) sessionFactory.getCurrentSession().save(migrationFlowEntity);

	}
	@Transactional(propagation = Propagation.REQUIRED)
	public MigrationFlowEntity getMigrationFlowByName(String migrationflowname) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl..getMigrationFlowByName()...");
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(MigrationFlowEntity.class);
		MigrationFlowEntity migrationFlowEntity= (MigrationFlowEntity) criteria.add(Restrictions.eq("migrationflowname", migrationflowname)).uniqueResult();
		return migrationFlowEntity;
	}

	}
