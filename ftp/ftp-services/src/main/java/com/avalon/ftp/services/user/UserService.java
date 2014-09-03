package com.avalon.ftp.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.user.PrivilegeBean;
import com.avalon.ftp.beans.user.RoleprivilegeBean;
import com.avalon.ftp.beans.user.UserRoleBean;
import com.avalon.ftp.beans.useraccount.RoleBean;
import com.avalon.ftp.beans.useraccount.UserBean;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.Rolerprivilege;
import com.avalon.ftp.entities.user.UserRole;

@Service("userService")
public interface UserService {

	List<PrivilegeBean> getAllPrivileges();

	int getRoleId(UserRoleBean userRoleBean);

	int saveUserRole(UserRoleBean userRoleBean);

	RoleprivilegeBean getRolesPrivileges(int rid);

	int saveRolePrivileges(RoleprivilegeBean roleprivilege);

	int deleteRolePrivileges(RoleprivilegeBean roleprivilege);

	int updateRolePrivileges(RoleprivilegeBean roleprivilege);

	List<UserRoleBean> getAllUserRoles();

	int deleteUserRole(int role_id);

	UserRoleBean getUserRoleInfo(int role_id);

	List<RoleprivilegeBean> getPrivilegeIdList(int role_id);

	List<RoleBean> getUserRole();

	List<UserBean> getUsers(int roleid, String uname);

	int getRoleId(UserRole userRoleBean);

	int saveUserRole(UserRole userRoleBean);
	
	Rolerprivilege getRolesPrivilegesEntity(int rid);

	int saveRolePrivilegesEntity(Rolerprivilege roleprivilege);
	
	int deleteRolePrivilegesEntity(Rolerprivilege roleprivilege);
	
	int updateRolePrivilegesEntity(Rolerprivilege roleprivilege);
	
	



}
