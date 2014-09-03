package com.avalon.ftp.services.useraccount;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.user.RoleprivilegeBean;
import com.avalon.ftp.beans.user.UserRoleBean;
import com.avalon.ftp.beans.useraccount.RoleBean;
import com.avalon.ftp.beans.useraccount.UserBean;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.entities.useraccount.Role;
import com.avalon.ftp.entities.useraccount.User;
import com.avalon.ftp.repository.approval.ApprovalRepositoryImpl;
import com.avalon.ftp.repository.useraccount.UserAccountRepository;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService{
	
	Logger logger = Logger.getLogger(ApprovalRepositoryImpl.class);

	@Autowired
	@Qualifier("userAccountRepository")
	UserAccountRepository userAccountRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public UserRoleBean getRoleId(String type) {
		// TODO Auto-generated method stub
		//UserRoleBean userBean = new UserRoleBean();
			UserRole userRole = new UserRole();
			userRole = userAccountRepository.getRoleId(type);
			return copyUserRole(userRole);		 
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public int addUser(UserBean userdetails) {
		// TODO Auto-generated method stub
			logger.info("@Entered addUser()");
			User user = new User();
			user.setEmail(userdetails.getEmail());
			user.setEmpid(userdetails.getEmpid());
			user.setFirstname(userdetails.getFirstname());
			user.setLastname(userdetails.getLastname());
			user.setRole(userdetails.getRole());
			user.setRole_id(userdetails.getRole_id());
			user.setStatus(userdetails.getStatus());
			user.setType(userdetails.getType());
			user.setUserid(userdetails.getUserid());
			user.setUseridd(userdetails.getUseridd());
			user.setUsername(userdetails.getUsername());
			user.setUserpass(userdetails.getUserpass());
			return userAccountRepository.addUser(user);			
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserBean> getUserById(int uid) {
		logger.info("@Entered into getUserById()");
		// TODO Auto-generated method stub
		List<UserBean> usrBean = new ArrayList<UserBean>();
		List<User> usr = new ArrayList<User>();
		usr = userAccountRepository.getUserById(uid);
		usrBean = copyUserList(usr);
		return usrBean;
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteSystemUser(int selecteduserid, int selectedUserStatus) {
		// TODO Auto-generated method stub
		logger.info("@Entered into deleteSystemUser()");
		return userAccountRepository.deleteSystemUser(selecteduserid,selectedUserStatus);
	}
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateUserStatus(int selecteduserid, int selectedUserStatus) {
		// TODO Auto-generated method stub
		return userAccountRepository.updateUserStatus(selecteduserid,selectedUserStatus);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public RoleBean findUserRole(int role_id) throws Exception {
		// TODO Auto-generated method stub
		logger.info("@Entered into finduserRole() & ID is "+role_id);
		RoleBean roleBean = new RoleBean();
		Role role = new Role();
		role = userAccountRepository.findUserRoleById(role_id);
		roleBean.setDescription(role.getDescription());
		roleBean.setRole(role.getRole());
		roleBean.setRole_id(role.getRole_Id());
		//roleBean.setUserRoles(role.getUserRoles());
		logger.info("Leaving finduserRole() & roleId "+roleBean.getRole_id());
		return roleBean;
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Roleprivilege> getPrivilegesByUserRole(int userRoleId) throws Exception{
		// TODO Auto-generated method stub		
		logger.info("@Entered into getPrivilegesByUserRole "+userRoleId);
		List<Roleprivilege> rolePrivelege = new ArrayList<Roleprivilege>();
		rolePrivelege = userAccountRepository.getPrivilegesByUserRole(userRoleId);		
		return rolePrivelege;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateUserRoleStatus(int role_id) {
		// TODO Auto-generated method stub		
		return userAccountRepository.updateUserRoleStatus(role_id);
	}
	
	
	
	// copying methods entities to beans
	private UserRoleBean copyUserRole(UserRole usrrole) {
		// TODO Auto-generated method stub
			UserRoleBean roleBean = new UserRoleBean();
			roleBean.setDescription(usrrole.getDescription());
			roleBean.setRole(usrrole.getRole());
			roleBean.setRole_id(usrrole.getRole_id());
			roleBean.setUserid(usrrole.getUserid());		 
			return roleBean;	
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

	
	private List<RoleprivilegeBean> copyRolePrivilege(List<Roleprivilege> RoleprivilegeBean) {
		// TODO Auto-generated method stub
		List<RoleprivilegeBean> roleBeanList = new ArrayList<RoleprivilegeBean>(RoleprivilegeBean.size());  
		for(Roleprivilege rp : RoleprivilegeBean)  
		{  
			RoleprivilegeBean rleBean = new RoleprivilegeBean();
			//rleBean.setModified_time(rp.getModified_time());
			rleBean.setPrivilegeId(rp.getPrivilegeId());
			rleBean.setRolePrivilegeId(rp.getRolePrivilegeId());
			rleBean.setUser_role_id(rp.getUser_role_id());
			rleBean.setUserid(rp.getUserid());			
			
			roleBeanList.add(rleBean);
		} 
		return roleBeanList;
	}





}
