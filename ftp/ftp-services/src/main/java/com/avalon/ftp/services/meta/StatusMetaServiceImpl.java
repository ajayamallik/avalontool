package com.avalon.ftp.services.meta;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.meta.StatusMetaBean;
import com.avalon.ftp.entities.meta.StatusMetaEntity;
import com.avalon.ftp.repository.meta.StatusMetaRepository;

@Service("statusMetaService")
public class StatusMetaServiceImpl implements StatusMetaService {

	protected static final Logger logger = Logger
			.getLogger(StatusMetaServiceImpl.class);
	@Autowired
	@Qualifier("statusMetaRepository")
	StatusMetaRepository statusMetaRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<StatusMetaEntity> getStatusNames() {
		// TODO Auto-generated method stub

		// need to remove after testing
		List<StatusMetaEntity> statusValues = statusMetaRepository
				.getStatusNames();
		logger.info("The status values:" + statusValues.get(0) + "..."
				+ statusValues.get(1));
		return statusMetaRepository.getStatusNames();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long addNewStatusValues(StatusMetaBean statusMetaBean) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaServiceImpl entered into addNewStatusValues()");
		StatusMetaEntity statusMetaEntity =  new StatusMetaEntity();
		statusMetaEntity.setStatusMetaId(statusMetaBean.getStatusMetaId());
		statusMetaEntity.setStatusValues(statusMetaBean.getStatusValues());
		return statusMetaRepository.addNewStatusValues(statusMetaEntity);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public List<StatusMetaBean> searchStatusValues() {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaServiceImpl entered into searchStatusValues()");
		List<StatusMetaEntity> statusMetaEntityList=new ArrayList<StatusMetaEntity>();
		List<StatusMetaBean> statusMetaBeansList=new ArrayList<StatusMetaBean>();
		statusMetaEntityList=statusMetaRepository.searchStatusValues();
		logger.info("@StatusMetaServiceImpl calling createStatusMetaBeans()");
		statusMetaBeansList=createStatusMetaBeans(statusMetaEntityList);
		return statusMetaBeansList;
	}
	
	public List<StatusMetaBean> createStatusMetaBeans(List<StatusMetaEntity> statusMetaEntityList){
		logger.info("@StatusMetaServiceImpl entered into createStatusMetaBeans()");
		List<StatusMetaBean> statusMetaBeanList=new ArrayList<StatusMetaBean>();
		for(StatusMetaEntity metaEntity:statusMetaEntityList){
			StatusMetaBean bean=new StatusMetaBean();
			bean.setStatusMetaId(metaEntity.getStatusMetaId());
			bean.setStatusValues(metaEntity.getStatusValues());
			statusMetaBeanList.add(bean);
		}
		
		return statusMetaBeanList;
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public StatusMetaBean editStatusValueByID(long statusMetaId) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaServiceImpl  editStatusValueByID()...");
		StatusMetaBean statusMetaBean=new StatusMetaBean();
		StatusMetaEntity statusMetaEntity=statusMetaRepository.editStatusValueByID(statusMetaId);
		statusMetaBean.setStatusMetaId(statusMetaEntity.getStatusMetaId());
		statusMetaBean.setStatusValues(statusMetaEntity.getStatusValues());
		return statusMetaBean;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public StatusMetaEntity getSearchValueById(long statusMetaId) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaServiceImpl  getSearchValueById()...");
		return statusMetaRepository.getStatusValueById(statusMetaId);
	}

	/* (non-Javadoc)
	 * @see com.avalon.ftp.services.meta.StatusMetaService#updateStatusValue(com.avalon.ftp.beans.meta.StatusMetaBean)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateStatusValue(StatusMetaBean statusMetaBean) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaServiceImpl  updateStatusValue()...calling getSearchValueById()");
		//getting record with id
		StatusMetaEntity statusMetaEntity=getSearchValueById(statusMetaBean.getStatusMetaId());
		//updating the fetched record with editted values
		statusMetaEntity.setStatusMetaId(statusMetaBean.getStatusMetaId());
		statusMetaEntity.setStatusValues(statusMetaBean.getStatusValues());
		logger.info("@StatusMetaServiceImpl  updateStatusValue()");
		statusMetaRepository.updateStatusValue(statusMetaEntity);
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteStatusValueByID(long statusMetaId) {
		// TODO Auto-generated method stub
		logger.info("@StatusMetaServiceImpl  deleteStatusValueByID()");
		statusMetaRepository.deleteStatusValueByID(statusMetaId);
		
	}

	
	
	

}
