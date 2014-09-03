package com.avalon.ftp.beans.meta;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class GroupMetaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9048106402032513967L;

	private long groupMetaId;
	@NotBlank(message = "Group Name is Required..!!")
	@Size(min = 8, message = "Enter proper GroupName")
	private String groupName;

	public long getGroupMetaId() {
		return groupMetaId;
	}

	public void setGroupMetaId(long groupMetaId) {
		this.groupMetaId = groupMetaId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
