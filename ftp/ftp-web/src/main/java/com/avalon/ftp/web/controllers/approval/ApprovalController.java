package com.avalon.ftp.web.controllers.approval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avalon.ftp.beans.approvals.ApprovalRequestBean;
import com.avalon.ftp.beans.environment.EnvironmentBean;
import com.avalon.ftp.entities.approvals.Approval;
import com.avalon.ftp.entities.approvals.ApprovalRequest;
import com.avalon.ftp.entities.meta.GroupMetaEntity;
import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.entities.meta.MigrationTypeEntity;
import com.avalon.ftp.entities.meta.StatusMetaEntity;
import com.avalon.ftp.services.admin.DeploymentService;
import com.avalon.ftp.services.approval.ApprovalService;
import com.avalon.ftp.services.meta.GroupMetaService;
import com.avalon.ftp.services.meta.MigrationFlowMetaService;
import com.avalon.ftp.services.meta.StatusMetaService;

//Added By Mallik
//Imlememted By Muralki
// Dt : 9-SEP-2014

@Controller
public class ApprovalController {

	Logger logger = Logger.getLogger(ApprovalController.class);
	@Autowired
	ApprovalService approvalService;
	
	// Merged by mallik
	//implemented by murali
	//Dt :  9-sep-2014
	@Autowired
	@Qualifier("migrationFlowMetaService")
	MigrationFlowMetaService migrationFlowMetaService;

	@Autowired
	@Qualifier("statusMetaService")
	StatusMetaService statusMetaService;

	@Autowired
	@Qualifier("groupMetaService")
	GroupMetaService groupMetaService;

	@Autowired
	@Qualifier("deploymentService")
	private DeploymentService deploymentService;
	

	/**
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/approval", method = RequestMethod.GET)
	public String getApprovalForm(ModelMap modelMap, HttpServletRequest request) {
		logger.info("@Entered into ApprovalForm");
		//Added By Mallik
		//Developed By Murali
		//Dt : 9-SEP-2014
		logger.info("@ApprovalController..calling migrationFlowMetaService.getMigrationFlows() ");
		List<MigrationFlowMetaEntity> migrationFlows = migrationFlowMetaService
				.getMigrationFlows();
		logger.info("@ApprovalController..calling statusMetaService.getStatusNames()");
		List<StatusMetaEntity> statusNames = statusMetaService.getStatusNames();
		logger.info("@ApprovalController..calling groupMetaService.getGroupMetaNames()");
		List<GroupMetaEntity> groupNames = groupMetaService.getGroupMetaNames();
		logger.info("@ApprovalController..returned from groupMetaServic");
		logger.info("@ApprovalController..calling migrationFlowMetaService.getMigrationTypeValues()");
		List<MigrationTypeEntity> migrationTypes = migrationFlowMetaService
				.getMigrationTypeValues();
		logger.info("@ApprovalController..returned from migrationFlowMetaService");
		modelMap.addAttribute("migrationFlows", migrationFlows);
		modelMap.addAttribute("statusNames", statusNames);
		modelMap.addAttribute("groupNames", groupNames);
		modelMap.addAttribute("migrationTypes", migrationTypes);

		/* adding drop down values in the session scope */
		request.getSession().setAttribute("migrationFlows", migrationFlows);
		request.getSession().setAttribute("statusNames", statusNames);
		request.getSession().setAttribute("groupNames", groupNames);
		request.getSession().setAttribute("migrationTypes", migrationTypes);
		
		
		modelMap.addAttribute("approvalBean", new Approval());
		return "ApprovalForm";

	}

	/**
	 *  
	 * @param request
	 * @param model
	 * @param approvalBean
	 * @return
	 */
	@RequestMapping("/submitforApproval")
	public String submitForApproval(@RequestParam(value = "selectedinstances", required = true) String selectedinstances,@RequestParam(value = "reqtype", required = true) String reqtype, HttpServletRequest request, Model model,
			@ModelAttribute("approvalBean") @Valid Approval approvalBean,BindingResult result,HttpSession session,ModelMap modelMap) {

		logger.info("Entered into ApprovalController submitForApproval()");
		
		logger.info("-=-=request type is "+reqtype);
		//Added By Mallik
		//Developed By Murali
		//Dt : 9-SEP-2014
		
		if (result.hasErrors()) {
			logger.info("entered into if(result.hasErrors())");
			/* accessing values from session scope */
			request.getSession().getAttribute("migrationFlows");
			request.getSession().getAttribute("statusNames");
			request.getSession().getAttribute("groupNames");

			modelMap.addAttribute("migrationFlows", request.getSession()
					.getAttribute("migrationFlows"));
			modelMap.addAttribute("statusNames", request.getSession()
					.getAttribute("statusNames"));
			modelMap.addAttribute("groupNames", request.getSession()
					.getAttribute("groupNames"));

			// modelMap.addAttribute("approvalBean", new Approval());
			return "ApprovalForm";
			// return "redirect:approval";

		} else {
			logger.info("entered into if(result.hasErrors()) else block...");
		
		List<ApprovalRequest> podt = new ArrayList<ApprovalRequest>();
		ApprovalRequest apreq = new ApprovalRequest();
		
		approvalBean.setRequestno("123");
		approvalBean.setRequestType(reqtype);
		approvalBean.setInstanceids(selectedinstances);
		int aprovalNo = approvalService.saveApproval(approvalBean);
		logger.info("Aproval No "+aprovalNo);		
		
		podt = approvalBean.getAprovalRequest();	
		for(int i=0;i<podt.size();i++){
			apreq = podt.get(i);
			System.out.println("Product Name:"+apreq.getApprovalid());					
			podt.get(i).setApprovalid(aprovalNo);	
			podt.get(i).setStatus("P");
			podt.get(i).setRequesttype(reqtype);
		}
		
		int appreq = approvalService.saveApprovalRequest(podt);		

		/*int i = approvalService.submitForApproval(approvalBean);
		logger.info("The return value of save()::" + i);
		logger.info("Control returned from approvalService");
		if (i == 1) {
			model.addAttribute("status", "Record inserted successfully");
		} else {
			model.addAttribute("status", "Record insertion Failed");
		}
		model.addAttribute("approvalBean", new ApprovalBean());*/
		if(appreq!=0){
			model.addAttribute("status", "Record inserted successfully..!!");
			model.addAttribute("approvalBean", new Approval());
		}
		else{
			model.addAttribute("status", "Record inserted failed..!!");
			model.addAttribute("approvalBean", new Approval());
		}
		return "ApprovalForm";

		}

	}

	
	/**
	 *  
	 * @param request
	 * @param model
	 * @param approvalBean
	 * @return
	 */
	@RequestMapping("/pendingapprovals")
	public String getPendingApprovals(HttpServletRequest request, Model model,
			@ModelAttribute("approvalBean") ApprovalRequestBean approvalBean) {
		logger.info("Entered into getPendingApprovals() and calling ..approvalService.getPendingApprovals()");

		List<ApprovalRequestBean> pendingList = approvalService.getPendingApprovals("P");
		model.addAttribute("pendingList", pendingList);
		return "PendingApprovals";

	}	
	
	/**
	 *  
	 * @param request
	 * @param session
	 * @param model
	 * @param approvalBean
	 * @return
	 */
	
	@RequestMapping("/approved")
	public String approvedProcess(HttpServletRequest request, HttpSession session,Model model,
			@ModelAttribute("pendingreq") ApprovalRequestBean approvalBean) {
		logger.info("Entered into approvedProcess()");
		
		int  appid=Integer.parseInt(request.getParameter("selid"));
		logger.info("selected id -=-=-="+appid);
				
		int j=	approvalService.approvalSubmitted(appid);
		 
		//List<Approval> pendingList = approvalservice.getPendingApprovals();
		  
		//modelMap.put("pendingList", pendingList);		
		  
		logger.info("  Pending Approvals ");
		 
		return "redirect:/pendingapprovals.html";

	}	
	
	
	/**
	 *  
	 * @param model
	 * @return
	 */
	@RequestMapping("/approvedrequests")
	public String approvedRequests(Model model){
		logger.info("@Entered into approved Request Form");		
		List<ApprovalRequestBean> pendingList = approvalService.getPendingApprovals("A");
		  
		model.addAttribute("pendingList", pendingList);	
		return "ApprovedRequest";
	}
	
	
	
	
	/**
	 *  
	 * @param model
	 * @return
	 */	
	
	@RequestMapping(value = "/admintab", method = RequestMethod.GET)
	public String getAdminTab(Model model) {
		/*modelMap.addAttribute("approvalBean", new ApprovalBean());*/
		return "AdminTab";

	}
	
	
	
	@RequestMapping(value = "getInstanceNames", method = RequestMethod.GET)
	protected void getJsonDataExampleFullDataBinding(HttpServletResponse response,Model model) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
         logger.info("@Entered into JSON Report");
        List<String>	instanceDetails = new ArrayList<String>();     //prodlist	
		
		ArrayList instance_Details = new ArrayList();   //prodList
		
		EnvironmentBean enviBean = new EnvironmentBean();  //itm
		
		 instanceDetails = approvalService.getInstanceDetails();
		 logger.info("Env Details in ApprovalCOntroler "+ instanceDetails);
		 model.addAttribute("instanceDetails", instanceDetails);
		/* Map<String, Object> mapModel = new HashMap<String, Object>();	 			 
		 	
			 for (int i = 0; i < prodlist.size(); i++) {
				 itm = prodlist.get(i);		     
			     
			     String itmName = itm.getItem_description();	     
			     
			     prodList.add(itmName);
			     
			   	}			

		 	mapModel.put("prodList", prodList);      */           
        
        String jsonString = mapper.writeValueAsString(model);
	    
	    AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();
	    MediaType jsonMimeType = MediaType.APPLICATION_JSON;
	    if (stringHttpMessageConverter.canWrite(String.class, jsonMimeType)) {
	        try {
	            stringHttpMessageConverter.write(jsonString, jsonMimeType, new ServletServerHttpResponse(response));
	        	} 	catch (IOException m_Ioe) {
	        								}
	        		catch (HttpMessageNotWritableException p_Nwe) {
	        													}
	    }
	}
	


	
}
