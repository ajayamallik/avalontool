package com.avalon.ftp.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.beans.meta.MigrationFlowMetaBean;
import com.avalon.ftp.entities.admin.MigrationFlowEntity;
import com.avalon.ftp.entities.meta.MigrationFlowMetaEntity;
import com.avalon.ftp.repository.admin.MigrationFlowRepository;

@Service("migrationFlowService")
public class MigrationFlowServiceImpl implements MigrationFlowService {
	
	Logger logger=Logger.getLogger(MigrationFlowServiceImpl.class);
	@Autowired
	@Qualifier("migrationFlowRepository")
	MigrationFlowRepository migrationFlowRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public long saveMigrationFlow(MigrationFlowBean migrationFlowBean) {
		logger.info("@ MigrationFlowServiceImpl...control enterd into saveMigrationFlow()");
		// TODO Auto-generated method stub
		MigrationFlowEntity migrationFlowEntity = new MigrationFlowEntity();
		migrationFlowEntity.setMigrationflowname(migrationFlowBean.getMigrationflowname());
		migrationFlowEntity.setSequence(migrationFlowBean.getSequence());
		migrationFlowEntity.setInstanceid(migrationFlowBean.getInstanceid());
		migrationFlowEntity.setAppreq(migrationFlowBean.getAppreq());
		migrationFlowEntity.setMigrationflow(migrationFlowBean.getMigrationflow());
		return migrationFlowRepository.saveMigrationFlow(migrationFlowEntity);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public MigrationFlowBean getMigrationFlowByName(String migrationflowname) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl...gethMigrationFlowByName()");
		MigrationFlowEntity migrationFlowEntitytity = migrationFlowRepository.getMigrationFlowByName(migrationflowname);
		MigrationFlowBean migrationFlowBean=new MigrationFlowBean();
		migrationFlowBean.setMigrationflowname(migrationFlowEntitytity.getMigrationflowname());
		migrationFlowBean.setSequence(migrationFlowEntitytity.getSequence());
		migrationFlowBean.setInstanceid(migrationFlowEntitytity.getInstanceid());
		migrationFlowBean.setMigrationflow(migrationFlowEntitytity.getMigrationflow());
		migrationFlowBean.setAppreq(migrationFlowEntitytity.getAppreq());
		return migrationFlowBean;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long addNewMigrationFlow(MigrationFlowMetaBean migrationFlowMetaBean) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl..addNewMigrationFlow()");
		MigrationFlowMetaEntity migrationFlowMetaEntity = new MigrationFlowMetaEntity();
		migrationFlowMetaEntity.setMigrationFlow(migrationFlowMetaBean
				.getMigrationFlow());
		return migrationFlowRepository
				.addNewMigrationFlow(migrationFlowMetaEntity);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public List<MigrationFlowMetaBean> searchMigrationFlow() {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl..searchMigrationFlow()");
		List<MigrationFlowMetaBean> migrationFlowMetaBeansList = new ArrayList<MigrationFlowMetaBean>();
		List<MigrationFlowMetaEntity> migrationFlowMetaEntitiesList = new ArrayList<MigrationFlowMetaEntity>();
		migrationFlowMetaEntitiesList = migrationFlowRepository
				.searchMigrationFlow();
		logger.info("@MigrationFlowServiceImpl..calling createMigrationFlowMetaBean()");
		migrationFlowMetaBeansList = createMigrationFlowMetaBean(migrationFlowMetaEntitiesList);
		logger.info(migrationFlowMetaBeansList.get(1));
		logger.info(migrationFlowMetaBeansList.get(2));
		logger.info(migrationFlowMetaBeansList.get(3));
		logger.info("@MigrationFlowServiceImpl..control going baack to controller Admin");
		return migrationFlowMetaBeansList;
	}

	public List<MigrationFlowMetaBean> createMigrationFlowMetaBean(
			List<MigrationFlowMetaEntity> migrationFlowList) {
		logger.info("@MigrationFlowServiceImpl..createMigrationFlowMetaBean()");
		List<MigrationFlowMetaBean> flowMetaBeans = new ArrayList<MigrationFlowMetaBean>();
		for (MigrationFlowMetaEntity metaEntity : migrationFlowList) {
			
			MigrationFlowMetaBean bean = new MigrationFlowMetaBean();
			bean.setMigrationFlowId(metaEntity.getMigrationFlowId());
			bean.setMigrationFlow(metaEntity.getMigrationFlow());
			flowMetaBeans.add(bean);
			
		}
		logger.info("@MigrationFlowServiceImpl.. returning from createMigrationFlowMetaBean() ");
		return flowMetaBeans;

	}
	@Transactional(propagation = Propagation.REQUIRED)
	public MigrationFlowMetaBean editMigrationFlowByID(long migrationFlowId) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl..editMigrationFlowByID()");
		MigrationFlowMetaBean migrationFlowMetaBean=new MigrationFlowMetaBean();
		MigrationFlowMetaEntity migrationFlowMetaEntity=migrationFlowRepository.editMigrationFlowByID(migrationFlowId);
		logger.info("The id of retriveed record is:"+migrationFlowMetaEntity.getMigrationFlowId());
		logger.info("The Name of retriveed record is:"+migrationFlowMetaEntity.getMigrationFlow());
		
		migrationFlowMetaBean.setMigrationFlowId(migrationFlowMetaEntity.getMigrationFlowId());
		migrationFlowMetaBean.setMigrationFlow(migrationFlowMetaEntity.getMigrationFlow());
		logger.info("@MigrationFlowServiceImpl..returning to controller..");
		return migrationFlowMetaBean;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateNewMigrationFlow(MigrationFlowMetaBean migrationFlowMetaBean) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl..updateNewMigrationFlow()");
		//calling getMigrationFlowById()
		MigrationFlowMetaEntity migrationFlowMetaEntity =getMigrationFlowById(migrationFlowMetaBean.getMigrationFlowId()) ;
		
		logger.info("@MigrationFlowServiceImpl Updating the record of id NO::"+migrationFlowMetaEntity.getMigrationFlowId());
		migrationFlowMetaEntity.setMigrationFlowId(migrationFlowMetaBean
				.getMigrationFlowId());
		migrationFlowMetaEntity.setMigrationFlow(migrationFlowMetaBean
				.getMigrationFlow());
		migrationFlowRepository.updateNewMigrationFlow(migrationFlowMetaEntity);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public MigrationFlowMetaEntity getMigrationFlowById(long migrationFlowId) {
		// TODO Auto-generated method stub
		logger.info("@MigrationFlowServiceImpl...getMigrationFlowById()..");
		return migrationFlowRepository.getMigrationFlowById(migrationFlowId);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMigrationFlowByID(long migrationFlowId) {
		// TODO Auto-generated method stub
		/*MigrationFlowMetaEntity migrationFlowMetaEntity=new MigrationFlowMetaEntity();
		migrationFlowMetaEntity.setMigrationFlow(migrationFlowMetaBean.getMigrationFlow());
		migrationFlowMetaEntity.setMigrationFlowId(migrationFlowMetaBean.getMigrationFlowId());*/
		migrationFlowRepository.deleteMigrationFlowByID(migrationFlowId);
		
		
	}

}
