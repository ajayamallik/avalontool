package com.avalon.ftp.services.meta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avalon.ftp.beans.meta.LookUpValuesBean;

@Service("lookUpValuesService")
public interface LookUpValuesService {
	public List<LookUpValuesBean> getLookUpValues();

}
