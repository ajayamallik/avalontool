package com.avalon.ftp.beans.meta;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class MigrationFlowMetaBean implements Serializable {

	private static final long serialVersionUID = -4259457150778042960L;

	private long migrationFlowId;
	/* @NotBlank(message="Enter Migration Flow Name") */
	@NotBlank(message = "Migration Flow Name is Required..!!")
	private String migrationFlow;

	@Size(min = 8, message = "Enter proper MigrationFlow Name")
	public long getMigrationFlowId() {
		return migrationFlowId;
	}

	public void setMigrationFlowId(long migrationFlowId) {
		this.migrationFlowId = migrationFlowId;
	}

	public String getMigrationFlow() {
		return migrationFlow;
	}

	public void setMigrationFlow(String migrationFlow) {
		this.migrationFlow = migrationFlow;
	}

}
