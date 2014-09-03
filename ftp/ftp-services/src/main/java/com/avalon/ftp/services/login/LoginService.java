package com.avalon.ftp.services.login;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.login.LoginBean;

@Service
public interface LoginService {
	public boolean verifyUser(LoginBean loginBean);

}
