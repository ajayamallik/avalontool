package com.avalon.ftp.repository.login;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.login.Login;

@Repository("loginRepositoryImpl")
public class LoginRepositoryImpl implements LoginRepository {

	protected static final Logger logger = Logger
			.getLogger(LoginRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Login> verifyUser() {
		// TODO Auto-generated method stub
		logger.info("LoginRepositoryImpl...verifyUser()");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Login.class);
		List<Login> login = criteria.list();
		return login;
	}

}
