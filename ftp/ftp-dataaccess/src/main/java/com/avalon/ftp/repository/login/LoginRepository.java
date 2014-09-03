package com.avalon.ftp.repository.login;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.login.Login;

@Repository
public interface LoginRepository {
	
	public List<Login> verifyUser();
}
