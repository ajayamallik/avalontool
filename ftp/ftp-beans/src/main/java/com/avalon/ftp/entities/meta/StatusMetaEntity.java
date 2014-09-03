package com.avalon.ftp.entities.meta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "StatusMetaEntity")
@Table(name = "status_meta")
public class StatusMetaEntity implements Serializable {

	private static final long serialVersionUID = -7317335339266458776L;
	@Id
	@GeneratedValue
	@Column(name = "status_meta_id")
	private long statusMetaId;
	@Column(name = "status_values")
	private String statusValues;

	public long getStatusMetaId() {
		return statusMetaId;
	}

	public void setStatusMetaId(long statusMetaId) {
		this.statusMetaId = statusMetaId;
	}

	public String getStatusValues() {
		return statusValues;
	}

	public void setStatusValues(String statusValues) {
		this.statusValues = statusValues;
	}

}
