package com.avalon.ftp.entities.meta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "GroupMetaEntity")
@Table(name = "group_meta")
public class GroupMetaEntity implements Serializable {

	private static final long serialVersionUID = 8472054187767164786L;
	@Id
	@GeneratedValue
	@Column(name = "group_meta_id")
	private long groupMetaId;
	@Column(name = "group_name")
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
