package com.avalon.ftp.repository.meta;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.avalon.ftp.entities.meta.LookUpValuesEntity;

@Repository("lookUpValuesRepository")
public interface LookUpValuesRepository {
	public List<LookUpValuesEntity> getLookUpValues();

}
