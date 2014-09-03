package com.avalon.ftp.repository.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.user.Privilege;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.Rolerprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.entities.useraccount.Role;
import com.avalon.ftp.entities.useraccount.User;

@Repository("userRoleRepository")
public interface UserRoleRepository {

	 public List <Privilege> getAllPrivileges();

	public int getRoleId(UserRole userRole);

	public int saveUserRole(UserRole userRole);

	public Roleprivilege getRolesPrivileges(int rid);

	public int saveRolePrivileges(Roleprivilege roleprivilege);

	public int deleteRolePrivileges(Roleprivilege roleprivilege);

	public int updateRolePrivileges(Roleprivilege roleprivilege);

	public List<UserRole> getAllUserRoles();

	public int deleteUserRole(int role_id);

	public int deleteUserRolePrivilege(int role_id);

	public UserRole getUserRoleInfo(int role_id);

	public List<Roleprivilege> getPrivilegeIdList(int role_id);

	public List<Role> getUserRole();

	public List<User> getUsers(int roleid, String uname);

	public Rolerprivilege getRolesPrivilegesEntity(int rid);
	

	public int saveRolePrivilegesEntity(Rolerprivilege rolerprivilege);

	public int deleteRolePrivilegesEntity(Rolerprivilege rolerprivilege);

	public int updateRolePrivileges(Rolerprivilege rolerprivilege);

}
