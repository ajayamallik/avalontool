package com.avalon.ftp.repository.meta;

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

import com.avalon.ftp.entities.meta.GroupMetaEntity;
import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.entities.user.Rolerprivilege;

@Repository("groupMetaRepository")
public class GroupMetaRepositoryImpl implements GroupMetaRepository {

	protected static final Logger logger = Logger
			.getLogger(GroupMetaRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GroupMetaEntity> getGroupMetaNames() {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaRepositoryImpl... executing  createCriteria() and returning to service..");
		return  sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class).list();
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public long addNewGroupValues(GroupMetaEntity groupMetaEntity) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaRepositoryImpl...executing addNewGroupValues()..save()");
		return (Long) sessionFactory.getCurrentSession().save(groupMetaEntity);
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GroupMetaEntity> searchGroupValues(String groupName) {
		// TODO Auto-generated method stub
		logger.info("@@GroupMetaRepositoryImpl..searchGroupValues()... executing createCriteria()");		
		//return sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class).list();
			return  (List<GroupMetaEntity>) sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class).add(Restrictions.eq("groupName",groupName)).list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GroupMetaEntity> searchGroupValues() {
		// TODO Auto-generated method stub
		logger.info("@@GroupMetaRepositoryImpl..searchGroupValues()... executing createCriteria()");		
		//return sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class).list();
			return sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class).list();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public GroupMetaEntity editGroupValueByID(long groupMetaId) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaRepositoryImpl..editMigrationFlowByID()...");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class);
		GroupMetaEntity groupMetaEntity=(GroupMetaEntity) criteria.add(Restrictions.eq("groupMetaId", groupMetaId)).uniqueResult();
		return groupMetaEntity;
	}
	/* (non-Javadoc)
	 * @see com.avalon.ftp.repository.meta.GroupMetaRepository#getGroupValueById(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public GroupMetaEntity getGroupValueById(long groupMetaId) {
		// TODO Auto-generated method stub
		
		logger.info("@GroupMetaRepositoryImpl ..getGroupValueById()");
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(GroupMetaEntity.class);
		return (GroupMetaEntity) criteria.add(Restrictions.eq("groupMetaId", groupMetaId)).uniqueResult();
	
	}
	/* (non-Javadoc)
	 * @see com.avalon.ftp.repository.meta.GroupMetaRepository#updateGroupValue(com.avalon.ftp.entities.meta.GroupMetaEntity)
	 */
	public void updateGroupValue(GroupMetaEntity groupMetaEntity) {
		// TODO Auto-generated method stub
		try {
			logger.info("updating record of ID NO:"+ groupMetaEntity.getGroupMetaId());
			sessionFactory.getCurrentSession().merge(groupMetaEntity);
			//sessionFactory.getCurrentSession().saveOrUpdate(migrationFlowMetaEntity);
		} catch (HibernateException e) {
			// TODO: handle exception
			logger.error("something went wrong while updating record....");
		}
		
	}
	/* (non-Javadoc)
	 * @see com.avalon.ftp.repository.meta.GroupMetaRepository#deleteGroupValueByID(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteGroupValueByID(long groupMetaId) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaRepositoryImpl ..deleteGroupValueByID()");
		sessionFactory.getCurrentSession().createQuery("DELETE FROM GroupMetaEntity WHERE groupMetaId = "+groupMetaId).executeUpdate();
		
	}
	
	
	
	
}