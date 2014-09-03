package com.avalon.ftp.web.controllers.meta;

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

import com.avalon.ftp.beans.meta.GroupMetaBean;
import com.avalon.ftp.services.meta.GroupMetaService;

@Controller
public class GroupValuesMetaController {
	protected static final Logger logger=Logger.getLogger(GroupValuesMetaController.class);
	@Autowired
	@Qualifier("groupMetaService")
	GroupMetaService groupMetaService;
	
	/*@RequestMapping(value="/getAddNewGroupValues",method=RequestMethod.POST)*/
	//changing POST to GET
	@RequestMapping(value="/groupvalues",method=RequestMethod.GET)
	public String getNewGroupValuesPage(HttpServletRequest request,@ModelAttribute("groupMetaBean")GroupMetaBean groupMetaBean ,ModelMap modelMap){
		logger.info("@GroupValuesMetaController Entered into getNewGroupValuesPage() ");
		//modelMap.addAttribute("groupMetaBean", new GroupMetaBean());
		logger.info("@GroupValuesMetaController Entered into getNewGroupValuesPage()before returning page... ");
		return "AddNewGroupvalues";
	}
	
	
	@RequestMapping(value="/addNewGroupValues",method=RequestMethod.POST)
	public String addNewGroupValues(@ModelAttribute("groupMetaBean") @Valid GroupMetaBean groupMetaBean,BindingResult result,ModelMap modelMap){
		logger.info("@GroupValuesMetaController Entered into the addNewGroupValues()..");
		if(result.hasErrors()){
			return "AddNewGroupvalues";
		}
		long id=groupMetaService.addNewGroupValues(groupMetaBean);
		modelMap.addAttribute("groupId", "The record No:-"+id+"-inserted successfully");
		modelMap.addAttribute("groupMetaBean", new GroupMetaBean());
		return "AddNewGroupvalues";
	}
	@RequestMapping(value = "/SearchGroupValues", method = RequestMethod.POST)
	public String searchGroupValues(HttpServletRequest request,@ModelAttribute("groupMetaBean")GroupMetaBean groupMetaBean,ModelMap modelMap) {
		logger.info("@GroupValuesMetaController .. searchMigrationFlow()..");
		
		List<GroupMetaBean> groupMetaBeans=groupMetaService.searchGroupValues();
		modelMap.addAttribute("groupMetaBeans", groupMetaBeans);
		return "SearchGroupValues";

	}
	@RequestMapping(value = "/editGroupValue", method = RequestMethod.GET)
	public String editGroupValues(HttpServletRequest request,@RequestParam("groupMetaId")long groupMetaId ,ModelMap modelMap) {
		logger.info("@GroupValuesMetaController .. searchMigrationFlow()..");
		
		GroupMetaBean groupMetaBean=groupMetaService.editGroupValueByID(groupMetaId);
		modelMap.addAttribute("groupMetaBean", groupMetaBean);
		modelMap.addAttribute("groupMetaBeanID", "The Record with ID NO:-"+groupMetaBean.getGroupMetaId()+"-edited..");
		
		return "AddNewGroupvalues";

	}

	@RequestMapping(value="/updateGroupValues",method=RequestMethod.POST)
	public String updateGroupValues(@ModelAttribute("groupMetaBean")GroupMetaBean groupMetaBean,ModelMap modelMap){
		logger.info("@GroupValuesMetaController Entered into the updateGroupValues()..");
		groupMetaService.updateGroupValue(groupMetaBean);
		modelMap.addAttribute("updatedgroupId", "The record No:-"+groupMetaBean.getGroupMetaId()+"-updated to"+groupMetaBean.getGroupName());
		modelMap.addAttribute("groupMetaBean", new GroupMetaBean());
		return "AddNewGroupvalues";
	}
	
	@RequestMapping(value = "/deleteGroupValue", method = RequestMethod.GET)
	public String deleteGroupValueByID(HttpServletRequest request,@RequestParam("groupMetaId") long groupMetaId,ModelMap modelMap) {
		logger.info("@GroupValuesMetaController..deleteNewMigrationFlow()..");
		logger.info("Group ID::"+groupMetaId);
		groupMetaService.deleteGroupValueByID(groupMetaId);
		List<GroupMetaBean> groupMetaBeans=groupMetaService.searchGroupValues();
		modelMap.addAttribute("groupMetaBeans", groupMetaBeans);
		modelMap.addAttribute("groupDeleteID", "The Group ID :-"+groupMetaId+"-Deleted");
		return "SearchGroupValues";

	}
	
}
