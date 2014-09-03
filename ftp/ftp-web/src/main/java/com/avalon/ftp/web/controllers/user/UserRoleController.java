package com.avalon.ftp.web.controllers.user;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avalon.ftp.beans.user.PrivilegeBean;
import com.avalon.ftp.beans.user.RoleprivilegeBean;
import com.avalon.ftp.beans.user.UserRoleBean;
import com.avalon.ftp.entities.user.Rolerprivilege;
import com.avalon.ftp.entities.user.UserRole;
import com.avalon.ftp.services.user.UserService;
import com.avalon.ftp.services.useraccount.UserAccountService;

@Controller
public class UserRoleController {
	protected static final Logger logger = Logger
			.getLogger(UserRoleController.class);
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	UserAccountService userAccountService;

	@RequestMapping(value = "/newUserRoleDetails", method = RequestMethod.GET)
	public String saveUser(HttpServletRequest request, Model model,@ModelAttribute("userRole") UserRoleBean userRoleBean) {
		logger.info("@UserRoleController.saveUser()");
		
		//Map<String, Object> modelMap = new HashMap<String, Object>();
		
		  List<PrivilegeBean> priviliegeList = userService.getAllPrivileges();	       
	      	        
		  logger.info(priviliegeList+"    privilegeList List");		

	        model.addAttribute("privilege", priviliegeList);
	        return "newUserRole";	
		
	}
	
	
	@RequestMapping("/saveOrUpdateUserRoleOriginal")
	public String  saveUserRole(HttpServletRequest request,Model model, @ModelAttribute("userRole") UserRoleBean userRoleBean) {
		
		
		  String roles = request.getParameter("roleList");
		  
		  logger.info(roles+"   roleees");
		  
		  	  
		  StringTokenizer roleToken = new StringTokenizer(roles, ",");
		  
		  
		 List roleList=new ArrayList();	      	
		  
		  while (roleToken.hasMoreTokens()) { 
            
              roleList.add(Integer.parseInt(roleToken.nextToken()));
          }
         
		
		  
		  int rid= userService.getRoleId(userRoleBean);
		  
		  logger.info("ridd-=-=-=-=-=->>"+rid);
		  
		  
		 // HttpSession session = request.getSession();
			
			//String userid=(String)session.getAttribute("username");
			
			//userRoleBean.setUserid(userid);
			
			if(rid>0)
			{
				
               userRoleBean.setRole_id(rid);
			  int j=	userService.saveUserRole(userRoleBean);
			  
			}
		  
		  if(rid==0)
		  {	
		  
			  
			  int j=	userService.saveUserRole(userRoleBean);	  
			  rid= userService.getRoleId(userRoleBean);
			  
		  
		  }
		  
		  
		  Rolerprivilege roleprivilege=userService.getRolesPrivilegesEntity(rid);
			
	        
	        if(roleprivilege==null)
	        {
	        	roleprivilege=	new Rolerprivilege();
	        	
	        	logger.info(rid + "   rid");				
				
			    for (int i = 0; i <roleList.size(); i++) {
				
				roleprivilege.setRolePrivilegeId(0);
				
				roleprivilege.setUser_role_id(rid);
								
				roleprivilege.setPrivilegeId(Integer.parseInt(roleList.get(i).toString()));
				
				roleprivilege.setModified_time(null);
				
				//roleprivilege.setUserid(userid);
				
				
				int k=userService.saveRolePrivilegesEntity(roleprivilege);
				
				      	
	        	//rolerprivilege.setRolePrivilegeId(0);
	        }
	        }
			    else
			    {
			    	
			    	 logger.info("rid "+rid);
			    	int k=userService.deleteRolePrivilegesEntity(roleprivilege);
			    	
			        for (int i = 0; i <roleList.size(); i++) {
			        	
			        	roleprivilege.setRolePrivilegeId(0);
						
					    roleprivilege.setUser_role_id(rid);
						
						roleprivilege.setPrivilegeId(Integer.parseInt(roleList.get(i).toString()));
						
						roleprivilege.setModified_time(null);
						
						//roleprivilege.setUserid(userid);
						
						int l=userService.updateRolePrivilegesEntity(roleprivilege);	
			    	
			    }
			
			
				}
		  
		  logger.info("rolelist  "+roleList);
		  
		  model.addAttribute("success_message", "Record Successfully Saved");
	      return "newUserRole";			
}
	
// Save Or update Test class
	@RequestMapping("/saveOrUpdateUserRole")
	public String  saveUserRoleTest(HttpServletRequest request,Model model, @ModelAttribute("userRole") UserRole userRoleBean) {
		
		
		  String roles = request.getParameter("roleList");
		  
		  logger.info(roles+"   roleees");
		  
		  	  
		  StringTokenizer roleToken = new StringTokenizer(roles, ",");
		  
		  
		 List roleList=new ArrayList();	      	
		  
		  while (roleToken.hasMoreTokens()) { 
           
              roleList.add(Integer.parseInt(roleToken.nextToken()));
          }
         		
		  
		  int rid= userService.getRoleId(userRoleBean);
		  
		  logger.info("ridd-=-=-=-=-=->>"+rid);		  
		  
		 // HttpSession session = request.getSession();
			
			//String userid=(String)session.getAttribute("username");
			
			//userRoleBean.setUserid(userid);
			
			if(rid>0)
			{
				
               userRoleBean.setRole_id(rid);
			  int j=	userService.saveUserRole(userRoleBean);
			  
			}
		  
		  if(rid==0)
		  {	
		  
			  
			  int j=	userService.saveUserRole(userRoleBean);	  
			  rid= userService.getRoleId(userRoleBean);
		  
		  }
		  
		  
		  Rolerprivilege roleprivilege=userService.getRolesPrivilegesEntity(rid);
		        
	        if(roleprivilege==null)
	        {
	        	roleprivilege=	new Rolerprivilege();
	        	
	        	logger.info(rid + "   rid");				
				
			    for (int i = 0; i <roleList.size(); i++) {
				
				roleprivilege.setRolePrivilegeId(0);
				
				roleprivilege.setUser_role_id(rid);
								
				roleprivilege.setPrivilegeId(Integer.parseInt(roleList.get(i).toString()));
				
				//roleprivilege.setModified_time(null);
				
				roleprivilege.setUserid("admin"); // need to put in session
				
				
				int k=userService.saveRolePrivilegesEntity(roleprivilege);
				
				      	
	        	//rolerprivilege.setRolePrivilegeId(0);
	        }
	        }
			    else
			    {
			    	
			    	 logger.info("rid "+rid);
			    	int k=userService.deleteRolePrivilegesEntity(roleprivilege);
			    	
			        for (int i = 0; i <roleList.size(); i++) {
			        	
			        	roleprivilege.setRolePrivilegeId(0);
						
					    roleprivilege.setUser_role_id(rid);
						
						roleprivilege.setPrivilegeId(Integer.parseInt(roleList.get(i).toString()));
						
						//roleprivilege.setModified_time(null);
						
						roleprivilege.setUserid("admin"); //need to put in sesion
						
						int l=userService.updateRolePrivilegesEntity(roleprivilege);	
						
						logger.info("Updated Succesfully"+l);
			    	
			    }
			
			
				}
		  
		  logger.info("rolelist  "+roleList);
		  
		  model.addAttribute("success_message", "Record Successfully Saved");
	      return "newUserRole";			
}
	
// Save Or Update Test Class End
	
		
	
	@RequestMapping("/manageUserRole")
	public String  getUserRoles(HttpServletRequest request,Model model, @ModelAttribute("userRole") UserRoleBean userRoleBean) {

		 
		  List<UserRoleBean> userRoleList = userService.getAllUserRoles();
		  
		  model.addAttribute("userRoleList", userRoleList);
		 
		  return "ManageUserRoles";
	
	}
	
	
	@RequestMapping("/deleteUserRole")
	public String  deleteUserRole(HttpServletRequest request,Model model, @ModelAttribute("userRole") UserRoleBean userRoleBean) {
	
	
		String selectedrole=request.getParameter("selectedRole");		
		
		logger.info("selected role "+selectedrole);
		
		int role_id=Integer.parseInt(selectedrole);
		
		int k= userService.deleteUserRole(role_id);
		
		int m = userAccountService.updateUserRoleStatus(role_id);
		
		logger.info("@User deletedSuccesfully");
		
		  List<UserRoleBean> userRoleList = userService.getAllUserRoles();
		  
		  model.addAttribute("userRoleList", userRoleList);
		 
		  return "ManageUserRoles";
	}
	

	@RequestMapping("/loadUserRoleDetails")	
	public String  loadUserRoleDetails(HttpServletRequest request,Model model, @ModelAttribute("userRole") UserRoleBean userRoleBean) {
		
		 String roleid=request.getParameter("role_id");
		 
		 logger.info("@Entered into loadUserRoleDetails()");
		 int role_id=Integer.parseInt(roleid);
		 
		 
		 userRoleBean=userService.getUserRoleInfo(role_id);
		 
		 String role=userRoleBean.getRole();
		 
		 String desc=userRoleBean.getDescription();
		 
		 model.addAttribute("role", role);
		 
		 model.addAttribute("desc", desc);
		 
		 
		 
		 List<RoleprivilegeBean> privilegeIdList=userService.getPrivilegeIdList(role_id);
		 
			  List<PrivilegeBean> priviliegeList = userService.getAllPrivileges();
			  model.addAttribute("privilege", priviliegeList);
		    
			  model.addAttribute("privilegeIdList", privilegeIdList);
		 
	/*	  List<Privilege> priviliegeList = roleService.getRolePrivileges(role_id);
	      model.addAttribute("privilege", priviliegeList);*/
	      
	      		 
		 
		// userrole.setRole(role)
		 
		logger.info(userRoleBean+"  user role"+role+"  "+desc+"  ");
		
	
		  return "newUserRole";
		
	}


}
