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

import com.avalon.ftp.beans.meta.StatusMetaBean;
import com.avalon.ftp.services.meta.StatusMetaService;

@Controller
public class StatusValuesMetaController {
	protected static final Logger logger = Logger
			.getLogger(StatusValuesMetaController.class);
	@Autowired
	@Qualifier("statusMetaService")
	StatusMetaService statusMetaService;

	//commented by murali
/*	@RequestMapping(value = "/getAddNeStatusValues", method = RequestMethod.POST)*/
	@RequestMapping(value = "/statusvalues", method = RequestMethod.GET)
	public String getStatusValuesForm(@ModelAttribute("statusMetaBean") StatusMetaBean statusMetaBean,
			HttpServletRequest request, ModelMap modelMap) {
		logger.info("@StatusValuesMetaController Entered into getStatusValuesForm()");
		modelMap.addAttribute("statusMetaBean", new StatusMetaBean());
		return "AddNewStatusValues";

	}
	@RequestMapping(value="/addNewStatusValues",method=RequestMethod.POST)
	public String addNewStatusValues(@ModelAttribute("statusMetaBean")@Valid StatusMetaBean statusMetaBean,BindingResult result,ModelMap modelMap){
		logger.info("@StatusValuesMetaController Entered into the addNewStatusValues()..");
		if(result.hasErrors()){
			return "AddNewStatusValues";
		}else{
		long id=statusMetaService.addNewStatusValues(statusMetaBean);
		modelMap.addAttribute("statusMetaId", "The record No:-"+id+"-inserted successfully");
		modelMap.addAttribute("statusMetaBean", new StatusMetaBean());
		return "AddNewStatusValues";
		}
	}
	
	@RequestMapping(value = "/SearchStatusValues", method = RequestMethod.POST)
	public String searchStatusValues(HttpServletRequest request,@ModelAttribute("statusMetaBean")StatusMetaBean statusMetaBean,ModelMap modelMap) {
		logger.info("@StatusValuesMetaController .. searchStatusValues..");
		List<StatusMetaBean> statusMetaBeans=statusMetaService.searchStatusValues();
		modelMap.addAttribute("statusMetaBeans", statusMetaBeans);
		return "SearchStatusValues";

	}
	@RequestMapping(value = "/editSearchValue", method = RequestMethod.GET)
	public String editSearchValues(HttpServletRequest request,@RequestParam("statusMetaId")long statusMetaId ,ModelMap modelMap) {
		logger.info("@StatusValuesMetaController .. editSearchValues()..");
		
		StatusMetaBean statusMetaBean=statusMetaService.editStatusValueByID(statusMetaId);
		modelMap.addAttribute("statusMetaBean", statusMetaBean);
		modelMap.addAttribute("statusMetaBeanID", "The Record with ID NO:-"+statusMetaBean.getStatusMetaId()+"-edited..");
		
		return "AddNewStatusValues";

	}
	@RequestMapping(value="/updateSearchValues.html",method=RequestMethod.POST)
	public String updateSearchValues(@ModelAttribute("statusMetaBean")StatusMetaBean statusMetaBean,ModelMap modelMap){
		logger.info("@StatusValuesMetaController Entered into the updateSearchValues()..");
		statusMetaService.updateStatusValue(statusMetaBean);
		modelMap.addAttribute("updatedStatusId", "The record No:-"+statusMetaBean.getStatusMetaId()+"-updated to"+statusMetaBean.getStatusValues());
		modelMap.addAttribute("statusMetaBean", new StatusMetaBean());
		return "AddNewStatusValues";
	}
	
	@RequestMapping(value = "/deleteStatusValue", method = RequestMethod.GET)
	public String deleteStatusValueByID(HttpServletRequest request,@RequestParam("statusMetaId") long statusMetaId,ModelMap modelMap) {
		logger.info("@StatusValuesMetaController..deleteStatusValueByID()..");
		logger.info("Status ID::"+statusMetaId);
		statusMetaService.deleteStatusValueByID(statusMetaId);
		List<StatusMetaBean> statusMetaBeans=statusMetaService.searchStatusValues();
		modelMap.addAttribute("statusMetaBeans", statusMetaBeans);
		modelMap.addAttribute("statusDeleteID", "The Status ID :-"+statusMetaId+"-Deleted");
		return "SearchStatusValues";

	}
	
	
	
}
