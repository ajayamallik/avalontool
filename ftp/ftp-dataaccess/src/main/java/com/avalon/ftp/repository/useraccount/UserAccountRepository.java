package com.avalon.ftp.repository.useraccount;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.beans.useraccount.RoleBean;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.entities.useraccount.Role;
import com.avalon.ftp.entities.useraccount.User;

@Repository("userAccountRepository")
public interface UserAccountRepository {

	UserRole getRoleId(String type);

	int addUser(User user);

	List<User> getUserById(int uid);

	int deleteSystemUser(int selecteduserid, int selectedUserStatus);

	int updateUserStatus(int selecteduserid, int selectedUserStatus);

	 com.avalon.ftp.entities.useraccount.User getUser(String login);

	Role findUserRoleById(int role_id);

	List<Roleprivilege> getPrivilegesByUserRole(int userRoleId) throws Exception;

	int updateUserRoleStatus(int role_id);



}
