package com.avalon.ftp.services.meta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.meta.GroupMetaBean;
import com.avalon.ftp.entities.meta.GroupMetaEntity;

@Service("groupMetaService")
public interface GroupMetaService {
	public List<GroupMetaEntity> getGroupMetaNames();
	public long addNewGroupValues(GroupMetaBean groupMetaBean);
	public List<GroupMetaBean> searchGroupValues(String groupName);
	public List<GroupMetaBean> searchGroupValues();
	public GroupMetaBean editGroupValueByID(long groupMetaId);
	public GroupMetaEntity getGroupValueById(long groupMetaId) ;
	public void updateGroupValue(GroupMetaBean groupMetaBean);
	public void deleteGroupValueByID(long groupMetaId);
	

}
