package com.avalon.ftp.entities.meta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MigrationFlowMetaEntity")
@Table(name = "migrationflow_meta")
public class MigrationFlowMetaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3825567347371165373L;

	@Id
	@GeneratedValue
	@Column(name = "mig_meta_id")
	private long migrationFlowId;
	@Column(name = "migrationflow_meta_name")
	private String migrationFlow;

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
