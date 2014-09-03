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
import com.avalon.ftp.entities.meta.StatusMetaEntity;

@Repository("statusMetaRepository")
public class StatusMetaRepositoryImpl implements StatusMetaRepository {

	protected static final Logger logger = Logger
			.getLogger(StatusMetaRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<StatusMetaEntity> getStatusNames() {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl... executing  createCriteria() and returning to service..");
		return sessionFactory.getCurrentSession()
				.createCriteria(StatusMetaEntity.class).list();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long addNewStatusValues(StatusMetaEntity statusMetaEntity) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl....addNewStatusValues()");
		return (Long) sessionFactory.getCurrentSession().save(statusMetaEntity);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<StatusMetaEntity> searchStatusValues() {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl..searchStatusValues().. executing createCriteria()");
		return sessionFactory.getCurrentSession()
				.createCriteria(StatusMetaEntity.class).list();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public StatusMetaEntity editStatusValueByID(long statusMetaId) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl..editStatusValueByID()...");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				StatusMetaEntity.class);
		StatusMetaEntity statusMetaEntity = (StatusMetaEntity) criteria.add(
				Restrictions.eq("statusMetaId", statusMetaId)).uniqueResult();
		return statusMetaEntity;
	}

	/* (non-Javadoc)
	 * @see com.avalon.ftp.repository.meta.StatusMetaRepository#getStatusValueById(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public StatusMetaEntity getStatusValueById(long statusMetaId) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl ..getStatusValueById()");
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(StatusMetaEntity.class);
		return (StatusMetaEntity) criteria.add(Restrictions.eq("statusMetaId", statusMetaId)).uniqueResult();
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateStatusValue(StatusMetaEntity statusMetaEntity) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl ..updateStatusValue()");
		try {
			logger.info("updating record of ID NO:"+ statusMetaEntity.getStatusMetaId());
			sessionFactory.getCurrentSession().merge(statusMetaEntity);
			//sessionFactory.getCurrentSession().saveOrUpdate(migrationFlowMetaEntity);
		} catch (HibernateException e) {
			// TODO: handle exception
			logger.error("something went wrong while updating record....");
		}
	}

	/* (non-Javadoc)
	 * @see com.avalon.ftp.repository.meta.StatusMetaRepository#deleteStatusValueByID(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteStatusValueByID(long statusMetaId) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaRepositoryImpl ..deleteStatusValueByID()");
		sessionFactory.getCurrentSession().createQuery("DELETE FROM StatusMetaEntity WHERE statusMetaId = "+statusMetaId).executeUpdate();
		
	}
	
	
	

}
