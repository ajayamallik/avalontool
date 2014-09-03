package com.avalon.ftp.web.controllers.meta;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.avalon.ftp.services.meta.MigrationFlowMetaService;

@Controller
public class MigrationFlowMetaController {
	protected static final Logger logger = Logger
			.getLogger(MigrationFlowMetaController.class);

	@Autowired
	@Qualifier("migrationFlowMetaService")
	MigrationFlowMetaService migrationFlowMetaService;

	public String getMigrationFlows() {
		return null;

	}
	

}
