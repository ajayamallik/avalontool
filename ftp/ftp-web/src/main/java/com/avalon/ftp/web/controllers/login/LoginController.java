package com.avalon.ftp.web.controllers.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avalon.ftp.beans.login.LoginBean;
import com.avalon.ftp.entities.useraccount.User;
import com.avalon.ftp.services.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired		
	private UserDetailsService userdetailsservice;

	protected static final Logger logger = Logger
			.getLogger(LoginController.class);
	@Autowired
	@Qualifier("loginServiceImpl")
	LoginService loginService;

	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public String getLoginPage(ModelMap model) {
		logger.info("@LoginController.getLoginPage()");
		model.addAttribute("loginBean", new LoginBean());
		return "Login";
	}

	@RequestMapping(value = "/getHome", method = RequestMethod.GET)
	public String getHomePage(
			@ModelAttribute("loginBean") @Valid LoginBean loginBean,
			BindingResult result) {
		loginBean.getUsername();
		loginBean.getPassword();
		logger.info("The entered credentials::"+loginBean.getUsername()+"..."+loginBean.getPassword());
		logger.info("@LoginController.getHomePage()::"
				+ loginService.verifyUser(loginBean));
		//Merged by mallik
		//done by murali
		//3-SEP-2014
		if(result.hasErrors()){
			return "Login";
		}else{
		return loginService.verifyUser(loginBean) ? "Home" : "Error";
		}
	}
	
	@RequestMapping(value = "/getErrorLogin", method = RequestMethod.GET)
	public String getErrorLoginPage(ModelMap model) {
		logger.info("@LoginController.getErrorLoginPage()");
		String message="Enter proper username and password";
		model.addAttribute("loginBean", new LoginBean());
		model.addAttribute("message", message);
		return "Login";	
	}
	
	@RequestMapping("/loginError")
	public String getLoginnForm(ModelMap model) {
		
		logger.info("error");		
		logger.info("@LoginController.getErrorLoginPage()");
		String message="Enter proper username and password";
		model.addAttribute("loginBean", new LoginBean());
		model.addAttribute("message", message);
		return "Login";
	}
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getUserForm(HttpServletRequest request,Model model) {	
		logger.info("@Entered into getuser Form");
		UserDetails userDetails= (UserDetails)SecurityContextHolder.getContext()
			     .getAuthentication().getPrincipal();
		HttpSession session = request.getSession(true); //create a new session
			
			
		logger.info(SecurityContextHolder.getContext().getAuthentication().getName()+"  Role");
		String userrole=SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		userrole=userrole.substring(0, 8);
		
		
		logger.info(userDetails.getUsername()+"  userDetails.getUsername()");
		
		
		User user=new User();
		   
		
	
		logger.info("user id in login controller   "+userDetails.getUsername());
	
		session.setAttribute("username", userDetails.getUsername());
		return  "AdminWelcome";		
	    
	     	}	

	
	
	
}
