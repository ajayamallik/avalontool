package com.avalon.ftp.repository.useraccount;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.entities.useraccount.Role;
import com.avalon.ftp.entities.useraccount.User;
import com.avalon.ftp.repository.approval.ApprovalRepositoryImpl;

@Repository("userAccountRepository")
public class UserAccountRepositoryImpl implements UserAccountRepository{
	
	Logger logger = Logger.getLogger(ApprovalRepositoryImpl.class);
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public UserRole getRoleId(String type){
		
		List<UserRole> roleList = new ArrayList<UserRole>();	
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserRole.class)
				.add(Restrictions.eq("role", type));
	
		 roleList = cr.list(); 
				
				if (roleList.size() > 0)
				{
					return roleList.get(0);
				}
				else
				{
					
					logger.info("  google");
					return null;
				}
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int addUser(User userdetails) {
		// TODO Auto-generated method stub
		
		String password = userdetails.getUserpass();
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		
		userdetails.setUserpass(encodedPassword);
		//userdetails.setUserpass(password); // delete when encode applied.
		userdetails.setStatus(1);

		sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
	 return 1;

	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> getUserById(int uid) {
		
		logger.info("@Entered into getUserById repository "+uid);
		// TODO Auto-generated method stub
		 List<User> userList = new ArrayList<User>();
			
			
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("userid", uid));
  	
			userList = cr.list();           	             
			sessionFactory.getCurrentSession().flush();
					
					
					if (userList.size() > 0)
					{
						logger.info("@ google");
						return userList;
					}
					else
					{
						
						logger.info("  google");
						return null;
					}
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteSystemUser(int selecteduserid, int selectedUserStatus) {
		// TODO Auto-generated method stub
			logger.info("userid in delete method "+selecteduserid);
		 
		 	Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();		 
		 	String sql = "delete from userdetails where status = ? and userid= ?";			  
			SQLQuery query = session.createSQLQuery(sql);
		 
			// String hql="update User set status=? where userid=? ";
			// Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0,selectedUserStatus);
			query.setInteger(1,selecteduserid);
			query.executeUpdate();
			tx.commit();
		 return 1;
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateUserStatus(int selecteduserid, int selectedUserStatus) {
		// TODO Auto-generated method stub
		 logger.info("userid  "+selecteduserid);	
		 logger.info("status  "+selectedUserStatus);
		 Session session =  sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 String sql = "update userdetails set status = ? where userid= ?";			  
				 SQLQuery query = session.createSQLQuery(sql);
				 logger.info("1");
		// String hql="update User set status=? where userid=? ";
		// Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 query.setInteger(0,selectedUserStatus);
		 query.setInteger(1,selecteduserid);
		 logger.info("2");
		 query.executeUpdate();
		 logger.info("3");
		 tx.commit();		 
		 return 1;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUser(String login) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();		
		logger.info(login+"   login");		
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username = :username");
		query.setParameter("username", login);
		userList = query.list();
		if (userList.size() > 0)
		{
			logger.info("userList  "+userList);
			return userList.get(0);
		}
		else
			return null;
	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public Role findUserRoleById(int role_id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Role> roleList = new ArrayList<Role>();
		
		logger.info("@Entered into Repository"+role_id);
		
		Criteria cr = session.createCriteria(Role.class)

				.add(Restrictions.eq("role_id", role_id));

			 roleList = cr.list();
				session.flush();
				tx.commit();
				
				logger.info(roleList.size()+"  roleListSize");
				
				if (roleList.size() > 0)
				{
					return roleList.get(0);
				}
				else
				{
					
					logger.info("  google");
					return null;
				}

	}


	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Roleprivilege> getPrivilegesByUserRole(int userRoleId) throws Exception {
		// TODO Auto-generated method stub
		 	@SuppressWarnings("unchecked")
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
 	   
			List<Roleprivilege> rolepList = new ArrayList<Roleprivilege>();
     	 
			logger.info(userRoleId+"   userRoleee Id");     		

 			Criteria cr = session.createCriteria(Roleprivilege.class)
 					.add(Restrictions.eq("user_role_id", userRoleId));
     	
 			 rolepList = cr.list();           	             
     	     session.flush();
     	     tx.commit();
     	     logger.info("rrrlole  "+rolepList.size()+"   size");
     	 
     	     if(rolepList.size()>0)
     	     {
     		 
     		 	logger.info("rrrlole");
     		 	return rolepList;
     	 	}
     	 
     	     else
     	     {
     		 return null;
     	 	}
	}


	public int updateUserRoleStatus(int role_id) {
		// TODO Auto-generated method stub
		 logger.info("Role id updated  "+role_id);
		 Session session =  sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 String sql = "update userdetails set role_id = ? where role_id= ?";			  
				 SQLQuery query = session.createSQLQuery(sql);
				 logger.info("1");
		// String hql="update User set status=? where userid=? ";
		// Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 query.setInteger(0,0);
		 query.setInteger(1,role_id);
		 logger.info("2");
		 query.executeUpdate();
		 logger.info("3");
		 tx.commit();		 
		 return 1;
	}




}
