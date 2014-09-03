package com.avalon.ftp.entities.meta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "LookUpValuesEntity")
@Table(name = "lookup_values")
public class LookUpValuesEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3466221957744995880L;

	@Id
	@GeneratedValue
	@Column(name = "lookup_values_id")
	private long lookUpValuesId;
	@Column(name = "lookup_values_name")
	private String lookUpValuesName;

	/**
	 * @return the lookUpValuesId
	 */
	public long getLookUpValuesId() {
		return lookUpValuesId;
	}

	/**
	 * @param lookUpValuesId
	 *            the lookUpValuesId to set
	 */
	public void setLookUpValuesId(long lookUpValuesId) {
		this.lookUpValuesId = lookUpValuesId;
	}

	/**
	 * @return the lookUpValuesName
	 */
	public String getLookUpValuesName() {
		return lookUpValuesName;
	}

	/**
	 * @param lookUpValuesName
	 *            the lookUpValuesName to set
	 */
	public void setLookUpValuesName(String lookUpValuesName) {
		this.lookUpValuesName = lookUpValuesName;
	}

}
