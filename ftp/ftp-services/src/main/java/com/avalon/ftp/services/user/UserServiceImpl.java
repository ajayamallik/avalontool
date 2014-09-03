package com.avalon.ftp.services.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.user.PrivilegeBean;
import com.avalon.ftp.beans.user.RoleprivilegeBean;
import com.avalon.ftp.beans.user.UserRoleBean;
import com.avalon.ftp.beans.useraccount.RoleBean;
import com.avalon.ftp.beans.useraccount.UserBean;
import com.avalon.ftp.entities.user.Privilege;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.Rolerprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.entities.useraccount.Role;
import com.avalon.ftp.entities.useraccount.User;
import com.avalon.ftp.repository.user.UserRoleRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier("userRoleRepository")
	UserRoleRepository userRoleRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<PrivilegeBean> getAllPrivileges(){
		// TODO Auto-generated method stub
		logger.info("Entered into getallprivileges()");
		List<PrivilegeBean> PrivilegeBean = new ArrayList<PrivilegeBean>();
		List<Privilege> Privilege = new ArrayList<Privilege>();
		Privilege =  userRoleRepository.getAllPrivileges();
		PrivilegeBean = copyPrivilegeList(Privilege);
		return PrivilegeBean;		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int getRoleId(UserRoleBean userRoleBean) {
		// TODO Auto-generated method stub
		UserRole userRole = new UserRole();
		userRole.setRole(userRoleBean.getRole());
		logger.info("@Entered into getRoleId()");
		return userRoleRepository.getRoleId(userRole);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveUserRole(UserRoleBean userRoleBean) {
		// TODO Auto-generated method stub
		UserRole userRole = new UserRole();
		userRole.setRole(userRoleBean.getRole());
		userRole.setRole_id(userRoleBean.getRole_id());
		userRole.setUserid(userRoleBean.getUserid());
		userRole.setDescription(userRoleBean.getDescription());	
		
		return userRoleRepository.saveUserRole(userRole);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public RoleprivilegeBean getRolesPrivileges(int rid) {
		// TODO Auto-generated method stub
		logger.info("@Entered getRolesPrivileges()");
		RoleprivilegeBean roleprivilegebean = new RoleprivilegeBean();
		Roleprivilege roleprivilege = new Roleprivilege();
		roleprivilege = userRoleRepository.getRolesPrivileges(rid);
		if( roleprivilege != null) {
		roleprivilegebean.setUser_role_id(roleprivilege.getUser_role_id());
		roleprivilegebean.setPrivilegeId(roleprivilege.getPrivilegeId());
		roleprivilegebean.setUserid(roleprivilege.getUserid());
		roleprivilegebean.setRolePrivilegeId(roleprivilege.getRolePrivilegeId());
		
		return roleprivilegebean;
		} else 
			return null;
	
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveRolePrivileges(RoleprivilegeBean roleprivilegebean) {
		// TODO Auto-generated method stub
	
		Roleprivilege roleprivilege = new Roleprivilege();
		roleprivilege.setPrivilegeId(roleprivilegebean.getPrivilegeId());
		roleprivilege.setRolePrivilegeId(roleprivilegebean.getRolePrivilegeId());
		roleprivilege.setUser_role_id(roleprivilegebean.getUser_role_id());
		roleprivilege.setUserid(roleprivilegebean.getUserid());
		
		return userRoleRepository.saveRolePrivileges(roleprivilege);
		 
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteRolePrivileges(RoleprivilegeBean roleprivilegebean) {
		// TODO Auto-generated method stub
		Roleprivilege roleprivilege = new Roleprivilege();
		roleprivilege.setPrivilegeId(roleprivilegebean.getPrivilegeId());
		roleprivilege.setRolePrivilegeId(roleprivilegebean.getRolePrivilegeId());
		roleprivilege.setUser_role_id(roleprivilegebean.getUser_role_id());
		roleprivilege.setUserid(roleprivilegebean.getUserid());
		
		return userRoleRepository.deleteRolePrivileges(roleprivilege);		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteRolePrivilegesEntity(Rolerprivilege rolerprivilege) {
		// TODO Auto-generated method stub
		return userRoleRepository.deleteRolePrivilegesEntity(rolerprivilege);
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateRolePrivileges(RoleprivilegeBean roleprivilegebean) {
		// TODO Auto-generated method stub
		Roleprivilege roleprivilege = new Roleprivilege();
		roleprivilege.setPrivilegeId(roleprivilegebean.getPrivilegeId());
		roleprivilege.setRolePrivilegeId(roleprivilegebean.getRolePrivilegeId());
		roleprivilege.setUser_role_id(roleprivilegebean.getUser_role_id());
		roleprivilege.setUserid(roleprivilegebean.getUserid());
		
		return userRoleRepository.updateRolePrivileges(roleprivilege);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserRoleBean> getAllUserRoles() {
		// TODO Auto-generated method stub
		logger.info("@Entered getAllUserRoles()");
		List<UserRoleBean> userRoleBeanList = new ArrayList<UserRoleBean>();
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		userRoleList = userRoleRepository.getAllUserRoles();
		userRoleBeanList = copyList(userRoleList);
		logger.info("List Of Bean Values "+ userRoleBeanList);
		return userRoleBeanList;
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUserRole(int role_id) {
		logger.info("@Entered into service deleteUserRole");
		// TODO Auto-generated method stub
		int k = userRoleRepository.deleteUserRolePrivilege(role_id);
		if(k==0)
		return userRoleRepository.deleteUserRole(role_id);
		else 
			return 1;
		 
	} 

	
	@Transactional(propagation = Propagation.REQUIRED)
	public UserRoleBean getUserRoleInfo(int role_id) {
		// TODO Auto-generated method stub
		UserRoleBean userRoleBean = new UserRoleBean();
		UserRole usrRole = new UserRole();
		usrRole = userRoleRepository.getUserRoleInfo(role_id);
		userRoleBean.setDescription(usrRole.getDescription());
		userRoleBean.setRole(usrRole.getRole());
		userRoleBean.setRole_id(usrRole.getRole_id());
		userRoleBean.setUserid(usrRole.getUserid());
		return userRoleBean;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<RoleprivilegeBean> getPrivilegeIdList(int role_id) {
		// TODO Auto-generated method stub
		List<RoleprivilegeBean> roleprivilegeBean = new ArrayList<RoleprivilegeBean>();
		List<Roleprivilege> roleprivilege = new ArrayList<Roleprivilege>();
		roleprivilege = userRoleRepository.getPrivilegeIdList(role_id);
		roleprivilegeBean = copyRolePrivilegeList(roleprivilege);
		return roleprivilegeBean;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<RoleBean> getUserRole() {
		// TODO Auto-generated method stub
		
		List<RoleBean> roleBean = new ArrayList<RoleBean>();
		List<Role> role = new ArrayList<Role>();
		role = userRoleRepository.getUserRole();
		roleBean = copyRoleList(role);
		return roleBean;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserBean> getUsers(int roleid, String uname) {
		// TODO Auto-generated method stub
		List<UserBean> usrBean = new ArrayList<UserBean>();
		List<User> usr = new ArrayList<User>();
		usr = userRoleRepository.getUsers(roleid, uname);
		usrBean = copyUserList(usr);
		return usrBean;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int getRoleId(UserRole userRole) {
		// TODO Auto-generated method stub
		logger.info("@Entered into getRoleId() for Entity");
		return userRoleRepository.getRoleId(userRole);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleRepository.saveUserRole(userRole);
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public Rolerprivilege getRolesPrivilegesEntity(int rid) {
		// TODO Auto-generated method stub
		return userRoleRepository.getRolesPrivilegesEntity(rid);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveRolePrivilegesEntity(Rolerprivilege rolerprivilege) {
		// TODO Auto-generated method stub
		return userRoleRepository.saveRolePrivilegesEntity(rolerprivilege);
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteRolePrivileges(Roleprivilege roleprivilege) {
		// TODO Auto-generated method stub
		return userRoleRepository.deleteRolePrivileges(roleprivilege);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateRolePrivileges(Roleprivilege roleprivilege) {
		// TODO Auto-generated method stub
		logger.info("-=-=-=-=-=-=-in service Impl=-=-=-=-=-=-"+roleprivilege.getPrivilegeId());
		return userRoleRepository.updateRolePrivileges(roleprivilege);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateRolePrivilegesEntity(Rolerprivilege rolerprivilege) {
		// TODO Auto-generated method stub
		logger.info("-=-=-=-=-=-=-in service Impl=-=-=-=-=-=-"+rolerprivilege.getPrivilegeId());
		return userRoleRepository.updateRolePrivileges(rolerprivilege);
	}
	


	//copying entity to bean
	private List<RoleprivilegeBean> copyRolePrivilegeList(List<Roleprivilege> roleprivileges) {
		// TODO Auto-generated method stub
		List<RoleprivilegeBean> roleprivilegeBeanList = new ArrayList<RoleprivilegeBean>(roleprivileges.size());  
		for(Roleprivilege roleprivilege : roleprivileges)  
		{  
			RoleprivilegeBean roleprivilegeBean = new RoleprivilegeBean();
			//roleprivilegeBean.setModified_time(roleprivilege.getModified_time());
			roleprivilegeBean.setPrivilegeId(roleprivilege.getPrivilegeId());
			roleprivilegeBean.setRolePrivilegeId(roleprivilege.getRolePrivilegeId());
			roleprivilegeBean.setUser_role_id(roleprivilege.getUser_role_id());
			roleprivilegeBean.setUserid(roleprivilege.getUserid());
			roleprivilegeBeanList.add(roleprivilegeBean);
		} 
		return roleprivilegeBeanList;	  
	}

	public List<UserRoleBean> copyList(List<UserRole> userRoles)  
	{  
	List<UserRoleBean> userRoleBeanList = new ArrayList<UserRoleBean>(userRoles.size());  
	for(UserRole usrRole : userRoles)  
	{  
		UserRoleBean usrRoleBean = new UserRoleBean();
		usrRoleBean.setDescription(usrRole.getDescription()) ;
		usrRoleBean.setRole(usrRole.getRole());
		usrRoleBean.setRole_id(usrRole.getRole_id());
		usrRoleBean.setUserid(usrRole.getUserid())	;
		userRoleBeanList.add(usrRoleBean);
	} 
	return userRoleBeanList;	  
	}

	public List<PrivilegeBean> copyPrivilegeList(List<Privilege> privileges)  
	{  
	List<PrivilegeBean> privilegeBeanList = new ArrayList<PrivilegeBean>(privileges.size());  
	for(Privilege privilege : privileges)  
	{  
		PrivilegeBean privilegeBean = new PrivilegeBean();
		privilegeBean.setName(privilege.getName());
		privilegeBean.setPrivilegeId(privilege.getPrivilegeId());
		privilegeBeanList.add(privilegeBean);
	} 
	return privilegeBeanList;
	  
	}

	private List<RoleBean> copyRoleList(List<Role> roles) {
		// TODO Auto-generated method stub
		List<RoleBean> roleBeanList = new ArrayList<RoleBean>(roles.size());  
		for(Role role : roles)  
		{  
			RoleBean roleBean = new RoleBean();
			roleBean.setDescription(role.getDescription());
			roleBean.setRole(role.getRole());
			roleBean.setRole_id(role.getRole_Id());
			roleBean.setUserRoles(role.getUserRoles());
			roleBeanList.add(roleBean);
		} 
		return roleBeanList;	
	}
	
	private List<UserBean> copyUserList(List<User> usrs) {
		// TODO Auto-generated method stub
		List<UserBean> usrBeanList = new ArrayList<UserBean>(usrs.size());  
		for(User usr : usrs)  
		{  
			UserBean usrBean = new UserBean();
			usrBean.setEmail(usr.getEmail());
			usrBean.setEmpid(usr.getEmpid());
			usrBean.setFirstname(usr.getFirstname());
			usrBean.setLastname(usr.getLastname());
			usrBean.setRole(usr.getRole());
			usrBean.setRole_id(usr.getRole_id());
			usrBean.setStatus(usr.getStatus());
			usrBean.setType(usr.getType());
			usrBean.setUserid(usr.getUserid());
			usrBean.setUseridd(usr.getUseridd());
			usrBean.setUsername(usr.getUsername());
			usrBean.setUserpass(usr.getUserpass());		
			
			usrBeanList.add(usrBean);
		} 
		return usrBeanList;
	}










}
