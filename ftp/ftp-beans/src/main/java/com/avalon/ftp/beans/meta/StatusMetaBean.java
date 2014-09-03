package com.avalon.ftp.beans.meta;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class StatusMetaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3419354267765993448L;
	private long statusMetaId;

	@NotBlank(message = "Enter Status values")
	@Size(min = 8, message = "Enter proper Status Value Name")
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
