package com.avalon.ftp.web.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avalon.ftp.beans.admin.DeploymentBean;
import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.entities.admin.MigrationFlowNamesEntity;
import com.avalon.ftp.services.admin.DeploymentService;
import com.avalon.ftp.services.admin.MigrationFlowNamesService;
import com.avalon.ftp.services.admin.MigrationFlowService;

@Controller("adminController")
public class AdminController {

	protected static final Logger logger = Logger
			.getLogger(AdminController.class);

	@Autowired
	@Qualifier("deploymentService")
	private DeploymentService deploymentService;
	@Autowired
	@Qualifier("migrationFlowNamesService")
	private MigrationFlowNamesService migrationFlowNamesService;
	@Autowired
	@Qualifier("migrationFlowService")
	private MigrationFlowService migrationFlowService;

	@RequestMapping(value = "/deploymenttab", method = RequestMethod.POST)
	public String getDeploymentForm(ModelMap modelMap,
			HttpServletRequest request) {
		logger.info("@AdminController..getDeploymentForm()..");

		modelMap.addAttribute("deploymentBean", new DeploymentBean());
		return "DeploymentTab";

	}

	@RequestMapping(value = "/savedeployment", method = RequestMethod.POST)
	public String saveDeploymentForm(
			@ModelAttribute("deploymentBean") DeploymentBean deploymentBean,
			BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {

		logger.info("@AdminController..saveDeploymentForm()..");

		logger.info(" form submitted values::"
				+ deploymentBean.getInstancename() + "..."
				+ deploymentBean.getHost() + ".." + deploymentBean.getPort()
				+ ".." + deploymentBean.getSid());
		long deploymentBeanId = deploymentService
				.saveDeployment(deploymentBean);
		modelMap.addAttribute("deploymentBean", new DeploymentBean());
		modelMap.addAttribute("deploymentBeanId", "Record No :"
				+ deploymentBeanId + "-" + "-" + "saved successfully..");
		return "DeploymentTab";

	}

	/* @RequestParam("term") String tagName */
	@RequestMapping(value = "/searchdeployment", method = RequestMethod.POST)
	public String searchDeploymentFormByInstanceName(
			@RequestParam("instancename") String instancename, ModelMap modelMap) {
		/*
		 * public String
		 * searchDeploymentFormByInstanceName(@ModelAttribute("deploymentBean"
		 * )DeploymentBean deploymentBean,BindingResult bindingResult, ModelMap
		 * modelMap, HttpServletRequest request) {
		 */

		logger.info("@AdminController..searchDeploymentFormByInstanceName()..");

		// logger.info(" form submitted values::"+deploymentBean.getInstancename()+"..."+deploymentBean.getHost()+".."+deploymentBean.getPort()+".."+deploymentBean.getSid());
		/*
		 * DeploymentBean
		 * deploymentBeanSearchResults=deploymentService.getDeploymentByInstanceName
		 * (deploymentBean.getInstancename());
		 */
		logger.info(" form submitted values::" + instancename);
		DeploymentBean deploymentBeanSearchResults = deploymentService
				.getDeploymentByInstanceName(instancename);
		modelMap.addAttribute("deploymentBean", deploymentBeanSearchResults);
		modelMap.addAttribute("instanceName",
				deploymentBeanSearchResults.getInstancename()
						+ "--Search results are showing below..");
		return "DeploymentTab";

	}

	@RequestMapping(value = "/migrationtab", method = RequestMethod.POST)
	public String getMigrationFlowForm(ModelMap modelMap,
			HttpServletRequest request) {
		logger.info("@AdminController.. getMigrationFlowForm()..");

		/*
		 * List<MigrationFlowNamesBean> migrationFlowNamesBean =
		 * migrationFlowNamesService .getMigrationFlowNames();
		 * modelMap.addAttribute
		 * ("migrationFlowNamesBean",migrationFlowNamesBean);
		 */
		List<MigrationFlowNamesEntity> migrationFlowNames = migrationFlowNamesService
				.getMigrationFlowNames();
		logger.info("@AdminController...control returned from service...");
		modelMap.addAttribute("migrationFlowNames", migrationFlowNames);
		modelMap.addAttribute("migrationFlowBean", new MigrationFlowBean());
		return "MigrationFlowTab";

	}
	@RequestMapping(value="/savemigration",method=RequestMethod.POST)
	public String saveMigrationFlowForm(@ModelAttribute("migrationFlowBean")MigrationFlowBean migrationFlowBean, ModelMap modelMap,HttpServletRequest request){
		
		logger.info("@AdminController...control enterd into saveMigrationFlowForm");
		long id=migrationFlowService.saveMigrationFlow(migrationFlowBean);
		modelMap.addAttribute("migrationStatus", "The Record No :--"+id+"--saved Successfully");
		modelMap.addAttribute("migrationFlowBean", new MigrationFlowBean());
		logger.info("saveMigrationFlowForm()...Fetching Drop down values for MigrationFlowNames..");
		List<MigrationFlowNamesEntity> migrationFlowNames = migrationFlowNamesService
				.getMigrationFlowNames();
		modelMap.addAttribute("migrationFlowNames", migrationFlowNames);
		logger.info("@AdminController...control returned from service to controller");
		return "MigrationFlowTab";
		
	}
	
	@RequestMapping(value = "/searchmigrationflowbyname", method = RequestMethod.POST)
	public String searchMigrationFlowByName(
			@ModelAttribute("migrationFlowBean")MigrationFlowBean migrationFlowBean, ModelMap modelMap) {
		logger.info("@AdminController...control enterd into searchMigrationFlowByName()..request param--"+migrationFlowBean.getMigrationflowname());
			MigrationFlowBean migrationFlowBeanByName=migrationFlowService.getMigrationFlowByName(migrationFlowBean.getMigrationflowname());
			modelMap.addAttribute("migrationFlowBean", migrationFlowBeanByName);	
			modelMap.addAttribute("migrationFlowStatus", migrationFlowBean.getMigrationflowname()+"--Record values are displaying");
			List<MigrationFlowNamesEntity> migrationFlowNames = migrationFlowNamesService
					.getMigrationFlowNames();
			modelMap.addAttribute("migrationFlowNames", migrationFlowNames);
			
			return "MigrationFlowTab";
	
	}
}
