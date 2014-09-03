package com.avalon.ftp.repository.meta;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.meta.LookUpValuesEntity;

@Repository("lookUpValuesRepository")
public class LookUpValuesRepositoryImpl implements LookUpValuesRepository {

	protected static final Logger logger = Logger.getLogger(LookUpValuesRepositoryImpl.class);
	
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED)
	public List<LookUpValuesEntity> getLookUpValues() {
		// TODO Auto-generated method stub
		logger.info("@LookUpValuesRepositoryImpl..IN getLookUpValues().");
		return  sessionFactory.getCurrentSession().createCriteria(LookUpValuesEntity.class).list();
	}

}
