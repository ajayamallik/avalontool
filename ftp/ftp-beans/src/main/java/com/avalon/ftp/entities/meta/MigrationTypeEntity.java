package com.avalon.ftp.entities.meta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MigrationTypeEntity")
@Table(name = "migration_type")
public class MigrationTypeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9040127298389787057L;

	@Id
	@GeneratedValue
	@Column(name = "migration_type_id")
	private long migrationTypeIid;
	@Column(name = "migration_type")
	private String migrationTypeName;

	public long getMigrationTypeIid() {
		return migrationTypeIid;
	}

	public void setMigrationTypeIid(long migrationTypeIid) {
		this.migrationTypeIid = migrationTypeIid;
	}

	public String getMigrationTypeName() {
		return migrationTypeName;
	}

	public void setMigrationTypeName(String migrationTypeName) {
		this.migrationTypeName = migrationTypeName;
	}

}
