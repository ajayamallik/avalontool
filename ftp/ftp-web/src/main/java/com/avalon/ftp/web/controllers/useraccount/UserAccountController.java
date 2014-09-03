package com.avalon.ftp.web.controllers.useraccount;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avalon.ftp.beans.user.UserRoleBean;
import com.avalon.ftp.beans.useraccount.RoleBean;
import com.avalon.ftp.beans.useraccount.UserBean;
import com.avalon.ftp.entities.useraccount.User;
import com.avalon.ftp.services.user.UserService;
import com.avalon.ftp.services.useraccount.UserAccountService;
import com.avalon.ftp.web.controllers.user.UserRoleController;

@Controller
public class UserAccountController {
	protected static final Logger logger = Logger
			.getLogger(UserRoleController.class);
	
	private transient int numberOfRecords;
	
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	@Qualifier("userAccountService")
	UserAccountService userAccountService;

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String saveUser(HttpServletRequest request, Model model,@ModelAttribute("userdetails") User userdetails) {
		
		logger.info("@UserRoleController.saveUser()");
				
		List<RoleBean> roleList = null;
		
		ArrayList userLevelList=new ArrayList();
		
		RoleBean role=new RoleBean();
		
		roleList=userService.getUserRole();
		
		logger.info("@service get UserRoles");
		
		for (int i = 0; i < roleList.size(); i++) {
		     role = roleList.get(i);		     
		     
		     String rrole=role.getRole();
		     userLevelList.add(rrole);		     
		   		}		
		 model.addAttribute("userLevelList", userLevelList);		
		logger.info(userLevelList+"  roleList");			
		return "CreateUser";
		
	}
	
	
	
	@RequestMapping("/createSystemUser")
	public String  createUser(HttpServletRequest request,Model model, @ModelAttribute("userdetails") UserBean userdetails,BindingResult result) {
			
		//UserValidator userval = new UserValidator();
	     //  userval.validate(userdetails, result);
		
		String uname=userdetails.getUsername();
		
		String pass=userdetails.getUserpass();
		
		String first=userdetails.getFirstname();
		
		String last =userdetails.getLastname();
		
		String type=userdetails.getType();
		
		int uid=userdetails.getUserid();		
		
		 HttpSession session = request.getSession();
			
		String userid=(String)session.getAttribute("username");
			
		userdetails.setUseridd(userid);
		
		System.out.println("uname    uid  "+uid+"  typeee  "+type);		
		
		//String type=userdetails.getType();
		
		UserRoleBean userrole = userAccountService.getRoleId(type);
		logger.info("user role :"+ userrole);
		
		int roleid=userrole.getRole_id();
		
		userdetails.setRole_id(roleid);			
		
		int i = userAccountService.addUser(userdetails);
		
		model.addAttribute("message", "Record Saved Succesfuly...");
		
		return "CreateUser";
    
	}
	
	
	@RequestMapping("/manageSystemUser")
	public String  manageUser(Model model, @ModelAttribute("userdetails") UserBean userdetails) {	
		
			logger.info("@Entered into manage User");
			
         	List<RoleBean> roleList = null;
		
         	ArrayList userLevelList=new ArrayList();
		
         	RoleBean role=new RoleBean();
		
         	roleList=userService.getUserRole();		
		
         	for (int i = 0; i < roleList.size(); i++) {
         		role = roleList.get(i);
         		String rrole=role.getRole();
         		userLevelList.add(rrole);		     
         	}
		
         	model.addAttribute("userLevelList", userLevelList);
		 
		return "ManageSystemUsers";
	}
	
	
	@RequestMapping("/searchSystemUsers")
	public String  searchUser(HttpServletRequest request,Model model, @ModelAttribute("userdetails") UserBean userdetails) {
		
		
		String uname=userdetails.getUsername();
		
		String type=userdetails.getType();

		UserRoleBean userrole = userAccountService.getRoleId(type);
		
		logger.info("@Entered name "+ uname);
		logger.info("@Entered type "+type);
		
		int roleid=userrole.getRole_id();	
		
		List<UserBean> userLoginList = null;
		   
		userLoginList=userService.getUsers(roleid,uname);
		   
		/*	ArrayList userLoginList=new ArrayList();
		
			for (int i = 0; i < userList.size(); i++) {
			     userdetails = userList.get(i);			     
			     String uuname=userdetails.getUsername();
			     userLoginList.add(uuname);			     
			     System.out.println("userLoginList  "+userLoginList);			     
			   		}*/
		   List<RoleBean> roleList = null;
			
		   ArrayList userLevelList=new ArrayList();
			
		   RoleBean role=new RoleBean();
			
		   roleList=userService.getUserRole();	
		   
			// Map<String, Object> mapModel = new HashMap<String, Object>();			
			for (int i = 0; i < roleList.size(); i++) {
			     role = roleList.get(i);	
			     String rrole=role.getRole();
			     userLevelList.add(rrole);
			}
			
			 model.addAttribute("userLevelList", userLevelList);
			 
			 model.addAttribute("userLoginList", userLoginList);
			 
			 
		/*
				int startFrom = Integer.parseInt(request.getParameter("startFrom") == null ? "0" : request.getParameter("startFrom"));
		        String actionType = request.getParameter("actionType") == null ? "" : request.getParameter("actionType");
		        int endNumber = startFrom + 10;
		      
		        if(actionType.equals("search"))
		            numberOfRecords = userLoginList.size();
		        SortUtil.sortUserLoginList(userLoginList);
		        int maxNumber;
		        if(numberOfRecords < endNumber)
		            maxNumber = numberOfRecords;
		        else
		            maxNumber = endNumber;
		        List reultsForPage = userLoginList.subList(startFrom, maxNumber);
		        if(!reultsForPage.isEmpty())
		            mapModel.put("userLoginList", reultsForPage);
		        if(userLoginList == null || userLoginList.size() == 0)
		        {
		            String message = "no User Found";
		            mapModel.put("message", message);
		        }
		        mapModel.put("numberOfRecords", Integer.valueOf(numberOfRecords));
		        mapModel.put("startFrom", Integer.valueOf(startFrom));
		        mapModel.put("maxNumber", Integer.valueOf(maxNumber));	    
		 
		*/
		return "ManageSystemUsers";	
		
	}
	
	
	@RequestMapping("/editSystemUser")
	public String  editUser(HttpServletRequest request,Model model, @ModelAttribute("userdetails") UserBean userdetails) {
		
		
			String userid=request.getParameter("selectedUserLoginId");
		
			logger.info("userid   "+userid);
		
			int uid=Integer.parseInt(userid);
		
			List<UserBean> userList =userAccountService.getUserById(uid);
		
			for (int i = 0; i < userList.size(); i++) {
		     userdetails = userList.get(i);	
		   		}	
		
			List<RoleBean> roleList = null;
			
			ArrayList userLevelList=new ArrayList();
			
			RoleBean role=new RoleBean();
			
			roleList=userService.getUserRole();
			
			 //Map<String, Object> mapModel = new HashMap<String, Object>();
			
			for (int i = 0; i < roleList.size(); i++) {
			     role = roleList.get(i);
			     		     
			     String rrole=role.getRole();
			     userLevelList.add(rrole);
			     
			   		}
			
			 model.addAttribute("userLevelList", userLevelList);
		
			 logger.info(userdetails.getType()+"  kk "+userdetails.getLastname()+"   userdetails");	
		
			 //ModelAndView modelAndView = new ModelAndView("CreateUser","userdetails",userdetails);
			 //modelAndView.addObject("userLevelList", userLevelList);
 
			 model.addAttribute("userLevelList", userLevelList);
			 model.addAttribute("userdetails",userdetails);
		
		return "CreateUser";
		
	}
	
	
	@RequestMapping("/deleteUserLogin")
	public String  deleteSystemUser(HttpServletRequest request,Model model, @ModelAttribute("userdetails") UserBean userdetails) {
		
        int selecteduserid=Integer.parseInt(request.getParameter("selectedUserLoginId"));
		
		int selectedUserStatus= Integer.parseInt(request.getParameter("selectedUserStatus"));
		
		
		int k=userAccountService.deleteSystemUser(selecteduserid,selectedUserStatus);		
		
		  	List<RoleBean> roleList = null;
			
	 		ArrayList userLevelList=new ArrayList();
	 		
	 		RoleBean role=new RoleBean();
	 		
	 		roleList=userService.getUserRole();
	 		
	 		// Map<String, Object> mapModel = new HashMap<String, Object>();
	 		
	 		for (int i = 0; i < roleList.size(); i++) {
	 		     role = roleList.get(i);
	 		     String rrole=role.getRole();
	 		     userLevelList.add(rrole);	 		     
	 		   		}	 	

		 	model.addAttribute("userLevelList", userLevelList);
	 		return "ManageSystemUsers";
	}
	
	
	@RequestMapping("/updateUserStatus")
	public String  disableSystemUser(HttpServletRequest request,Model model, @ModelAttribute("userdetails") UserBean userdetails) {	
	
	   String uname=userdetails.getUsername();
		
		String type=userdetails.getType();	
		
		logger.info("@Entered into disableSystemUser()"+uname);
		
		int selecteduserid=Integer.parseInt(request.getParameter("selectedUserLoginId"));
		
		int selectedUserStatus= Integer.parseInt(request.getParameter("selectedUserStatus"));
		
	    int k=userAccountService.updateUserStatus(selecteduserid,selectedUserStatus); 		
		
	    List<RoleBean> roleList = null;
		
	 		ArrayList userLevelList=new ArrayList();
	 		
	 		RoleBean role=new RoleBean();
	 		
	 		roleList=userService.getUserRole();
	 		
	 		 //Map<String, Object> mapModel = new HashMap<String, Object>();
	 		
	 		for (int i = 0; i < roleList.size(); i++) {
	 		     role = roleList.get(i);
	 		     
	 		     
	 		     String rrole=role.getRole();
	 		     userLevelList.add(rrole);
	 		     
	 		   		}
	 		
	 		 model.addAttribute("userLevelList", userLevelList);
	 		return "ManageSystemUsers";	
	}

	
	
	

}
