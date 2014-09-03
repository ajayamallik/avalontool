package com.avalon.ftp.repository.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.user.Privilege;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.Rolerprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.entities.useraccount.Role;
import com.avalon.ftp.entities.useraccount.User;
import com.avalon.ftp.repository.approval.ApprovalRepositoryImpl;

@Repository("userRoleRepository")
public class UserRoleRepositoryImpl implements UserRoleRepository {
	Logger logger = Logger.getLogger(ApprovalRepositoryImpl.class);
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Privilege> getAllPrivileges(){
		logger.info("@Repository entered into getAllPrivileges()");
		// TODO Auto-generated method stub
		List<Privilege> privilegeList = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Privilege.class);
		privilegeList = criteria.list();
		return privilegeList;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int getRoleId(UserRole userRole){
		logger.info("@Repository entered into getRoleId()");
		String role=userRole.getRole();
		logger.info("Role Entered "+role);
	    Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserRole.class)  
        		
        		.add(Restrictions.eq("role",role));
        		
	    List<UserRole> rlist = cr.list();
	    
	    int size = rlist.size();
	    
	    int rid=0;
		
		for (int i = 0; i <size; i++) {
			UserRole element = rlist.get(i);
         
			rid=element.getRole_id();
			
			logger.info(rid+"   ridsf");
			
		}
		
		return rid;
			
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);			
		return 0;

	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public Roleprivilege getRolesPrivileges(int rid) {
		// TODO Auto-generated method stub
		logger.info("@Entered getRolesPrivileges(rid) "+rid);
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Roleprivilege.class).add(Restrictions.eq("user_role_id",rid));
		
		    	List<Roleprivilege> RoleList = cr.list();	  
		    	logger.info("-=-=-=-=-=-=-=-=-=-=-=-=-");	
		
		    	if (RoleList.size() > 0){
		    		logger.info("-=-=-=-if part");
		    		return RoleList.get(0);
		    	}
		    	else{
		    		logger.info("returns null");
		    	
		    		return null;
		    	}
	}
	
	

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public Rolerprivilege getRolesPrivilegesEntity(int rid) {
		// TODO Auto-generated method stub
		logger.info("@Entered getRolesPrivileges(rid)  "+rid);
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Rolerprivilege.class).add(Restrictions.eq("user_role_id",rid));
		
		    	List<Rolerprivilege> RoleList = cr.list();	  
		    	logger.info("-=-=-=-=-=-=-=-=-=-=-=-=-");	
		
		    	if (RoleList.size() > 0){
		    		logger.info("-=-=-=-if part");
		    		return RoleList.get(0);
		    	}
		    	else{
		    		logger.info("returns null");		    	
		    		return null;
		    	}
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveRolePrivileges(Roleprivilege roleprivilege) {
		
		// TODO Auto-generated method stub		

        	//int rid=	roleprivilege.getRolePrivilegeId();

        	logger.info("Entered into saveRolePrivilegeds()"+roleprivilege.getPrivilegeId());
	
        	sessionFactory.getCurrentSession().save(roleprivilege);	
        	
        	return 0;		
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveRolePrivilegesEntity(Rolerprivilege roleprivilege) {
		// TODO Auto-generated method stub
		logger.info("Entered into saveRolePrivilege Entity()"+roleprivilege.getPrivilegeId());
		
    	sessionFactory.getCurrentSession().save(roleprivilege);	
    	
    	return roleprivilege.getPrivilegeId();
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteRolePrivileges(Roleprivilege roleprivilege) {
		// TODO Auto-generated method stub		
		 	int rid=	roleprivilege.getUser_role_id();
	        String hql = "delete from Roleprivilege where user_role_id= :user_role_id"; 
			sessionFactory.getCurrentSession().createQuery(hql).setParameter("user_role_id",new Integer(rid)).executeUpdate();
	        logger.info("Deleted rolePrivileges");
	        return 0;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteRolePrivilegesEntity(Rolerprivilege rolerprivilege) {
		// TODO Auto-generated method stub
		int rid=	rolerprivilege.getUser_role_id();
        String hql = "delete from Roleprivilege where user_role_id= :user_role_id"; 
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("user_role_id",new Integer(rid)).executeUpdate();
        logger.info("Deleted rolePrivileges");
        return rolerprivilege.getPrivilegeId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateRolePrivileges(Roleprivilege roleprivilege) {
		// TODO Auto-generated method stub
		
		logger.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+roleprivilege.getPrivilegeId());
		//roleprivilege.setModified_time("2014-08-05 12:53:25");
		
		sessionFactory.getCurrentSession().saveOrUpdate(roleprivilege);
		return roleprivilege.getPrivilegeId();
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateRolePrivileges(Rolerprivilege rolerprivilege) {
		// TODO Auto-generated method stub
		logger.info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+rolerprivilege.getPrivilegeId());
		//roleprivilege.setModified_time("2014-08-05 12:53:25");
		
		sessionFactory.getCurrentSession().saveOrUpdate(rolerprivilege);
		return rolerprivilege.getPrivilegeId();
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserRole> getAllUserRoles() {
		// TODO Auto-generated method stub
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserRole.class);	
		userRoleList = cr.list();           	             
		return userRoleList;
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUserRole(int role_id) {
		logger.info("@Entered into deleteUserRole");
		// TODO Auto-generated method stub
		String hql = "delete from UserRole where role_id= :role_id"; 
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("role_id",new Integer(role_id)).executeUpdate();
		return 0;		
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUserRolePrivilege(int user_role_id) {
		// TODO Auto-generated method stub
		logger.info("@Entered into deleteUserRolePrivilege()");
		// TODO Auto-generated method stub
		String hql = "delete from Roleprivilege where user_role_id= :user_role_id"; 
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("user_role_id",new Integer(user_role_id)).executeUpdate();
		return 0;
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public UserRole getUserRoleInfo(int role_id) {
		// TODO Auto-generated method stub
		 Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserRole.class)  
	          		
	          		.add(Restrictions.eq("role_id",role_id));
	          		
			    List<UserRole> userRoleList = cr.list();	  
		
			
			if (userRoleList.size() > 0)
				return userRoleList.get(0);
			else
				return null;
		
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Roleprivilege> getPrivilegeIdList(int role_id) {
		// TODO Auto-generated method stub
		 Criteria cr = sessionFactory.getCurrentSession().createCriteria(Roleprivilege.class)  
	          		
	          		.add(Restrictions.eq("user_role_id",role_id));

			    List<Roleprivilege> privilegeIdList = cr.list();
		
			    return privilegeIdList;
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Role> getUserRole() {
		// TODO Auto-generated method stub
		 List<Role> roleList = new ArrayList<Role>();       	 
	      
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Role.class);					
    	
			roleList = cr.list();           	             
    	    
		return roleList;		
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> getUsers(int roleid, String uname) {
		// TODO Auto-generated method stub
		logger.info("@Entered getUsers() repository");
		List<User> userList = new ArrayList<User>();
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("role_id", roleid))
				.add(Restrictions.like("username","%"+uname+"%"))	;
	
		 userList = cr.list();           	             
	            	 
		 logger.info("user  "+userList.size()+"   size");
	 
		 if(userList.size()>0)
		 	{
		 
			 logger.info("userList"+userList.get(0).getType());
			 return userList;
		 	}
	 
		 else
		 	{
			 return null;
		 	}		
	
	}










	
}
