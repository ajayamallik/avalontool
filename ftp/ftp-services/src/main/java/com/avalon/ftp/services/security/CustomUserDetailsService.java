package com.avalon.ftp.services.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.login.AdminDetails;
import com.avalon.ftp.entities.user.Privilege;
import com.avalon.ftp.entities.user.Roleprivilege;
import com.avalon.ftp.repository.approval.ApprovalRepositoryImpl;
import com.avalon.ftp.repository.useraccount.UserAccountRepository;
import com.avalon.ftp.services.useraccount.UserAccountService;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;



@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	Logger logger = Logger.getLogger(ApprovalRepositoryImpl.class);
	
	 /** string constant for holding max login attempts. */
  //  private static final int MAX_LOGIN_COUNT = 3;
    
    /** string constant for holding error massage user not found. */
    private static final String USER_NOT_FOUND = "user not found";
    
   
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	 private UserAccountService userAccountService;

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		
		logger.info("@Entered into loadUserByUserName()  &"+login+" This is login name");
		com.avalon.ftp.entities.useraccount.User domainUser = userAccountRepository.getUser(login);
		
		if(domainUser!=null)
		{
			
			  int status=	domainUser.getStatus();
			  logger.info("Status "+status);
			  
			  if (status==0)
			  {
				  logger.info("user Not Found");
				  throw new UsernameNotFoundException(USER_NOT_FOUND);  
			  }
				
		
			
			
		}
		else if (domainUser == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND);
        }
        return buildUserFromUserEntity(domainUser);
		
	}
	


	@Transactional(readOnly = true)
    User buildUserFromUserEntity(com.avalon.ftp.entities.useraccount.User domainUser) {

        User systemUser = null;        
        String username = domainUser.getUsername();
        int userRoleId = domainUser.getRole_id();
        String password = domainUser.getUserpass();
        
          
        logger.info("username  "+username+"   password"+password);
    
        boolean accountNonLocked = true;
        boolean enabled=true;
        String userRole = "";
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
        
        com.avalon.ftp.entities.useraccount.Role userRoleObj = null; 
        com.avalon.ftp.beans.useraccount.RoleBean userRoleObj1 = null;
        com.avalon.ftp.entities.user.Roleprivilege  roleprivilege = null;
        
        try {
            userRoleObj1 = userAccountService.findUserRole(domainUser.getRole_id());  
            
            userRole=userRoleObj1.getRole();
            logger.info("@usrRole "+userRole);
            List<Roleprivilege> roleprivileges = userAccountService.getPrivilegesByUserRole(userRoleObj1.getRole_id());            
            logger.info("@roleprivileges "+roleprivileges)  ;         
            String role=  roleprivileges.get(1).toString();  
            logger.info("@Role Id :"+role) ;
             
            Privilege  privileges=null; 
             
         	for (int i = 0; i < roleprivileges.size(); i++) {
         		logger.info("@Entered loop");
         		  roleprivilege = roleprivileges.get(i);  		     
   		     
   		           privileges=roleprivilege.getPrivilege();
   		           
   		           logger.info("@Before Authorities added");
   		   
   		           authorities.add(new GrantedAuthorityImpl(privileges.getName())); 		    
   		    
   		   		}		
   	 
          
          logger.info(authorities+" authorities  "+userRole)  ;    	
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        logger.info("@After Authorities Added");
        systemUser =
                new AdminDetails(username, password, userRole, userRoleId, "1",
                        enabled, accountNonLocked, authorities);
        
       
        return systemUser;
	}
      
 	
}