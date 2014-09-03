package com.avalon.ftp.beans.admin;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class MigrationFlowNamesBean implements Serializable {

	private static final long serialVersionUID = 3908127745999139631L;

	private int migId;
	/*private String migrationFlowName;*/
	@NotEmpty
	private String migrationflowname; 

	public int getMigId() {
		return migId;
	}

	public void setMigId(int migId) {
		this.migId = migId;
	}

	public String getMigrationflowname() {
		return migrationflowname;
	}

	public void setMigrationflowname(String migrationflowname) {
		this.migrationflowname = migrationflowname;
	}

	/*public String getMigrationFlowName() {
		return migrationFlowName;
	}

	public void setMigrationFlowName(String migrationFlowName) {
		this.migrationFlowName = migrationFlowName;
	}
*/
}
