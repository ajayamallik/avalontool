package com.avalon.ftp.repository.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;

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
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long addNewMigrationFlow(
			MigrationFlowMetaEntity migrationFlowMetaEntity) {
		logger.info("@MigrationFlowRepositoryImpl..addNewMigrationFlow()...");
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().save(
				migrationFlowMetaEntity);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings("unchecked")
	public List<MigrationFlowMetaEntity> searchMigrationFlow() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl..searchMigrationFlow()... executing createCriteria()");
		return sessionFactory.getCurrentSession().createCriteria(MigrationFlowMetaEntity.class).list();
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public MigrationFlowMetaEntity editMigrationFlowByID(long migrationFlowId) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl..editMigrationFlowByID()...");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				MigrationFlowMetaEntity.class);
		
		MigrationFlowMetaEntity migrationFlowMetaEntity = (MigrationFlowMetaEntity) criteria.add(Restrictions.eq("migrationFlowId", migrationFlowId))
				.uniqueResult();
		logger.info("@MigrationFlowRepositoryImpl..returning to service..."+migrationFlowMetaEntity.getMigrationFlowId());
		return migrationFlowMetaEntity;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateNewMigrationFlow(
			MigrationFlowMetaEntity migrationFlowMetaEntity) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl...updateNewMigrationFlow...merge() calling");
		// TODO Auto-generated method stub
		 /*sessionFactory.getCurrentSession().merge(migrationFlowMetaEntity);*/
		try {
			logger.info("updating record of ID NO:"+ migrationFlowMetaEntity.getMigrationFlowId());
			sessionFactory.getCurrentSession().merge(migrationFlowMetaEntity);
			//sessionFactory.getCurrentSession().saveOrUpdate(migrationFlowMetaEntity);
		} catch (HibernateException e) {
			// TODO: handle exception
			logger.error("something went wrong while updating record....");
		}
		
		
	}
	//helper method to updateNewMigrationFlow()
	@Transactional(propagation = Propagation.REQUIRED)
	public MigrationFlowMetaEntity getMigrationFlowById(long migrationFlowId) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl ..getMigrationFlowById()");
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(MigrationFlowMetaEntity.class);
		return (MigrationFlowMetaEntity) criteria.add(Restrictions.eq("migrationFlowId", migrationFlowId)).uniqueResult();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMigrationFlowByID(long migrationFlowId) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowRepositoryImpl ..deleteMigrationFlowByID()");
		sessionFactory.getCurrentSession().createQuery("DELETE FROM MigrationFlowMetaEntity WHERE migrationFlowId = "+migrationFlowId).executeUpdate();
		
	}

	

}
