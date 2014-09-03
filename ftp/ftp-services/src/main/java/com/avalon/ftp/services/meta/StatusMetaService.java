package com.avalon.ftp.services.meta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.meta.StatusMetaBean;
import com.avalon.ftp.entities.meta.StatusMetaEntity;

@Service("statusMetaService")
public interface StatusMetaService {

	public List<StatusMetaEntity> getStatusNames();
	public long addNewStatusValues(StatusMetaBean statusMetaBean);
	public List<StatusMetaBean> searchStatusValues();
	public StatusMetaBean editStatusValueByID(long statusMetaId); 
	
	public StatusMetaEntity getSearchValueById(long statusMetaId) ;
	public void updateStatusValue(StatusMetaBean statusMetaBean);
	public void deleteStatusValueByID(long statusMetaId);
}
