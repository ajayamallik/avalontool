package com.avalon.ftp.entities.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MigrationFlowNames")
@Table(name = "migration_flow_name")
public class MigrationFlowNamesEntity implements Serializable {

	private static final long serialVersionUID = 819221665560248608L;
	@Id
	@GeneratedValue
	@Column(name = "mig_id")
	private int migId;
	@Column(name = "migration_flow_name")
	/*private String migrationFlowName;*/
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
