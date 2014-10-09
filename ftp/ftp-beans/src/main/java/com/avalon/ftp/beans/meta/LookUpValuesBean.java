package com.avalon.ftp.beans.meta;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LookUpValuesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 822860165790004668L;

	private long lookUpValuesId;
	@NotEmpty(message="LookUp Value is required")
	private String lookUpValuesName;

	public long getLookUpValuesId() {
		return lookUpValuesId;
	}

	public void setLookUpValuesId(long lookUpValuesId) {
		this.lookUpValuesId = lookUpValuesId;
	}

	public String getLookUpValuesName() {
		return lookUpValuesName;
	}

	public void setLookUpValuesName(String lookUpValuesName) {
		this.lookUpValuesName = lookUpValuesName;
	}

}
