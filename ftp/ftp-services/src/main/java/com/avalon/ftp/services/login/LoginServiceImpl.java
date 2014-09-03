package com.avalon.ftp.services.login;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.login.LoginBean;
import com.avalon.ftp.entities.login.Login;
import com.avalon.ftp.repository.login.LoginRepository;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	protected static final Logger logger=Logger.getLogger(LoginServiceImpl.class);
	@Autowired
	@Qualifier("loginRepositoryImpl")
	LoginRepository loginRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean verifyUser(LoginBean loginBean) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl...verifyUser()");
		List<Login> login = loginRepository.verifyUser();

		return checkLogin(login, loginBean);
	}

	public boolean checkLogin(List<Login> login, LoginBean loginBean) {
		logger.info("LoginServiceImpl...checkLogin()");
		boolean flag = false;
		for (Login compareBean : login) {
			if (compareBean.getUsername().equals(loginBean.getUsername())
					&& compareBean.getPassword()
							.equals(loginBean.getPassword())) {
				flag = true;
			}
		}
		return flag;

	}

}
