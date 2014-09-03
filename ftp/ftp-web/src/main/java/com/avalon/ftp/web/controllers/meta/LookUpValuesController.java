package com.avalon.ftp.web.controllers.meta;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avalon.ftp.beans.meta.LookUpValuesBean;
import com.avalon.ftp.services.meta.LookUpValuesService;

@Controller
public class LookUpValuesController {
	protected static final Logger logger=Logger.getLogger(LookUpValuesController.class);
	@Autowired
	@Qualifier("lookUpValuesService")
	LookUpValuesService lookUpValuesService;

	@RequestMapping(value="/configtab",method=RequestMethod.POST)
	public String getLookUpValuesListForm(@ModelAttribute("lookUpValuesBean") LookUpValuesBean lookUpValuesBean,ModelMap modelMap){
		logger.info("@LookUpValuesController Enterd into getLookUpValuesListForm()..");
		List<LookUpValuesBean> lookUpValuesBeans= lookUpValuesService.getLookUpValues();
		modelMap.addAttribute("lookUpValuesBeans", lookUpValuesBeans);
		
		return "LookUpValuesList";
		
	}
}
