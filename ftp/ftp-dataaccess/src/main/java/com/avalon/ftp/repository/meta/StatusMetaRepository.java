package com.avalon.ftp.repository.meta;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.meta.StatusMetaEntity;

@Repository("statusMetaRepository")
public interface StatusMetaRepository {
	public List<StatusMetaEntity> getStatusNames();
	public long addNewStatusValues(StatusMetaEntity statusMetaEntity); 
	
	public List<StatusMetaEntity> searchStatusValues();
	public StatusMetaEntity editStatusValueByID(long statusMetaId);
	public StatusMetaEntity getStatusValueById(long statusMetaId);
	public void updateStatusValue(StatusMetaEntity statusMetaEntity);
	public void deleteStatusValueByID(long statusMetaId);
	
}
