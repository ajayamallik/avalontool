package com.avalon.ftp.services.useraccount;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.user.RoleprivilegeBean;
import com.avalon.ftp.beans.user.UserRoleBean;
import com.avalon.ftp.beans.useraccount.RoleBean;
import com.avalon.ftp.beans.useraccount.UserBean;
import com.avalon.ftp.entities.user.Roleprivilege;

@Service("userAccountService")
public interface UserAccountService {

	UserRoleBean getRoleId(String type);

	int addUser(UserBean userdetails);

	List<UserBean> getUserById(int uid);

	int deleteSystemUser(int selecteduserid, int selectedUserStatus);

	int updateUserStatus(int selecteduserid, int selectedUserStatus);

	RoleBean findUserRole(int role_id) throws Exception;

	List<Roleprivilege> getPrivilegesByUserRole(int userRoleId) throws Exception;

	int updateUserRoleStatus(int role_id);;

}
