package com.avalon.ftp.services.meta;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.meta.LookUpValuesBean;
import com.avalon.ftp.entities.meta.LookUpValuesEntity;
import com.avalon.ftp.repository.meta.LookUpValuesRepository;

@Service("lookUpValuesService")
public class LookUpValuesServiceImpl implements LookUpValuesService {

	@Autowired
	@Qualifier("lookUpValuesRepository")
	LookUpValuesRepository lookUpValuesRepository;
	protected static final Logger logger = Logger.getLogger(LookUpValuesServiceImpl.class);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<LookUpValuesBean> getLookUpValues() {
		// TODO Auto-generated method stub
		logger.info("@LookUpValuesServiceImpl..entered into getLookUpValues()..");
		List<LookUpValuesEntity> lookUpValuesEntities=  lookUpValuesRepository.getLookUpValues();
		List<LookUpValuesBean> lookUpValuesBeans=createLookUpValuesBean(lookUpValuesEntities);
		return lookUpValuesBeans;
	}
	
	public List<LookUpValuesBean> createLookUpValuesBean(List<LookUpValuesEntity> lookUpValuesEntities){
		List<LookUpValuesBean>  lookUpValuesBeansList=new ArrayList<LookUpValuesBean>();
		for(LookUpValuesEntity entity:lookUpValuesEntities){
			LookUpValuesBean bean=new LookUpValuesBean();
			bean.setLookUpValuesId(entity.getLookUpValuesId());
			bean.setLookUpValuesName(entity.getLookUpValuesName());
			lookUpValuesBeansList.add(bean);
		}
		
		return lookUpValuesBeansList;
		
	}

}
