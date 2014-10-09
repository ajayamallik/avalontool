package com.avalon.ftp.repository.meta;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.meta.GroupMetaEntity;

@Repository("groupMetaRepository")
public interface GroupMetaRepository {
	public List<GroupMetaEntity> getGroupMetaNames();
	public long addNewGroupValues(GroupMetaEntity groupMetaEntity);
	public List<GroupMetaEntity> searchGroupValues(String groupName);
	public List<GroupMetaEntity> searchGroupValues();
	public GroupMetaEntity editGroupValueByID(long groupMetaId);
	public GroupMetaEntity getGroupValueById(long groupMetaId);
	public void updateGroupValue(GroupMetaEntity groupMetaEntity);
	
	public void deleteGroupValueByID(long groupMetaId);
	
		
}
 