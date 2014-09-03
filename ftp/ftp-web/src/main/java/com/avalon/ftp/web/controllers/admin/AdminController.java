package com.avalon.ftp.web.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.avalon.ftp.beans.meta.MigrationFlowMetaBean;
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
			@ModelAttribute("deploymentBean") @Valid DeploymentBean deploymentBean,
			BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {

		logger.info("@AdminController..saveDeploymentForm()..");
		
		//Added by mallik.
		//implemented by murali.
		//Dt: 3-SEP-2014
		if(bindingResult.hasErrors()){
			return "DeploymentTab";
		}
		
		
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
	public String saveMigrationFlowForm(@ModelAttribute("migrationFlowBean") @Valid MigrationFlowBean migrationFlowBean,BindingResult result, ModelMap modelMap,HttpServletRequest request){
		
		logger.info("@AdminController...control enterd into saveMigrationFlowForm");
		//Merged by mallik
		//implemented bymurali
		//Dt:3-SEP-2014
		if(result.hasErrors()){
			logger.info("saveMigrationFlowForm()...Fetching Drop down values for MigrationFlowNames..");
			List<MigrationFlowNamesEntity> migrationFlowNames = migrationFlowNamesService
					.getMigrationFlowNames();
			logger.info("@AdminController...control returned from service...");
			modelMap.addAttribute("migrationFlowNames", migrationFlowNames);
			/*modelMap.addAttribute("migrationFlowBean", new MigrationFlowBean());*/
			return "MigrationFlowTab";
		}else{
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
	//Merged by mallik
	//implemented by murali
	//dt: 3-SEP-2014
	//method to display configTab page.
	/*	@RequestMapping(value = "/configtab", method = RequestMethod.POST)
		public String getConfigurationForm(HttpServletRequest request,ModelMap modelMap) {
			logger.info("@AdminController..getConfigurationForm()..");

		//	modelMap.addAttribute("deploymentBean", new DeploymentBean());
			return "ConfigTab";

		}*/
		//@RequestMapping(value = "/configtab", method = RequestMethod.POST)
		public String getConfigurationForm(HttpServletRequest request,ModelMap modelMap) {
			logger.info("@AdminController..getConfigurationForm()..");

		//	modelMap.addAttribute("deploymentBean", new DeploymentBean());
			return "ConfigTab";

		}
		//methods for creating new Migration Flow Lookup values migrationflow
		/*@RequestMapping(value = "/addmigrationtab", method = RequestMethod.POST)*/
		@RequestMapping(value = "/migrationflow", method = RequestMethod.GET)
		public String getAddMigrationForm(HttpServletRequest request,@ModelAttribute("migrationFlowMetaBean")MigrationFlowMetaBean migrationFlowMetaBean,ModelMap modelMap) {
			logger.info("@AdminController..getAddMigrationForm()..");

		//	modelMap.addAttribute("deploymentBean", new DeploymentBean());
			return "AddMigrationFlowValues";

		}
		//saving new migration flow lookup values
		@RequestMapping(value = "/addNewMigrationFlow", method = RequestMethod.POST)
		public String addNewMigrationFlow(HttpServletRequest request,@ModelAttribute("migrationFlowMetaBean")@Valid MigrationFlowMetaBean migrationFlowMetaBean,BindingResult result,ModelMap modelMap) {
			logger.info("@AdminController..addNewMigrationFlow()..");
			if(result.hasErrors()){
				return "AddMigrationFlowValues";
			}else{
			long id=migrationFlowService.addNewMigrationFlow(migrationFlowMetaBean);
			modelMap.addAttribute("newMigrationFlow", "The Record No :--"+id+"--saved Successfully");
			modelMap.addAttribute("migrationFlowMetaBean", new MigrationFlowMetaBean());
			return "AddMigrationFlowValues";
			}

		}
		//searching list of available lookup values from db
		@RequestMapping(value = "/searchMigrationFlow", method = RequestMethod.POST)
		public String searchMigrationFlow(HttpServletRequest request,@ModelAttribute("migrationFlowMetaBean")MigrationFlowMetaBean migrationFlowMetaBean,ModelMap modelMap) {
			logger.info("@AdminController.. searchMigrationFlow()..");
			
			List<MigrationFlowMetaBean> migrationFlowMetaBeans=migrationFlowService.searchMigrationFlow();
			modelMap.addAttribute("migrationFlowMetaBeans", migrationFlowMetaBeans);
			return "SearchMigrationFlow";

		}
		//editing migrationFlow wrt to id
		@RequestMapping(value = "/editMigrationFlow", method = RequestMethod.GET)
		public String editMigrationFlow(HttpServletRequest request,@RequestParam("migrationFlowId") long migrationFlowId,ModelMap modelMap) {
			logger.info("@AdminController.. editMigrationFlow()..");
			
			MigrationFlowMetaBean migrationFlowMetaBean=migrationFlowService.editMigrationFlowByID(migrationFlowId);
			logger.info("MIGFlow ID is::"+migrationFlowMetaBean.getMigrationFlowId());
			logger.info("MIGFLOW Name::"+migrationFlowMetaBean.getMigrationFlow());
			modelMap.addAttribute("migrationFlowMetaBean", migrationFlowMetaBean);
			return "AddMigrationFlowValues";

		}
		
		//updating the migrationFlow wrt to ID
		@RequestMapping(value = "/updateNewMigrationFlow", method = RequestMethod.POST)
		public String updateNewMigrationFlow(HttpServletRequest request,@ModelAttribute("migrationFlowMetaBean")MigrationFlowMetaBean migrationFlowMetaBean,ModelMap modelMap) {
			logger.info("@AdminController..updateNewMigrationFlow()..");
			logger.info("MIGFlow ID is::"+migrationFlowMetaBean.getMigrationFlowId());
			logger.info("MIGFLOW Name::"+migrationFlowMetaBean.getMigrationFlow());
			migrationFlowService.updateNewMigrationFlow(migrationFlowMetaBean);
			//modelMap.addAttribute("newMigrationFlow", "The Record No :--"+id+"--saved Successfully");
			modelMap.addAttribute("migrationFlowMetaBean", new MigrationFlowMetaBean());
			return "AddMigrationFlowValues";

		}
		//deleting the migrationFlow wrt to ID
		@RequestMapping(value = "/deleteMigrationFlow", method = RequestMethod.GET)
		public String deleteNewMigrationFlow(HttpServletRequest request,@RequestParam("migrationFlowId") long migrationFlowId,ModelMap modelMap) {
			logger.info("@AdminController..deleteNewMigrationFlow()..");
			/*logger.info("MIGFlow ID is::"+migrationFlowMetaBean.getMigrationFlowId());
			logger.info("MIGFLOW Name::"+migrationFlowMetaBean.getMigrationFlow());*/
			logger.info("MIGFLOW ID::"+migrationFlowId);
			migrationFlowService.deleteMigrationFlowByID(migrationFlowId);
			List<MigrationFlowMetaBean> migrationFlowMetaBeans=migrationFlowService.searchMigrationFlow();
			modelMap.addAttribute("migrationFlowMetaBeans", migrationFlowMetaBeans);
			return "SearchMigrationFlow";

		}
}
