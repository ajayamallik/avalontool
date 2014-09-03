package com.avalon.ftp.services.meta;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.avalon.ftp.beans.meta.GroupMetaBean;
import com.avalon.ftp.entities.meta.GroupMetaEntity;
import com.avalon.ftp.repository.meta.GroupMetaRepository;

@Service("groupMetaService")
public class GroupMetaServiceImpl implements GroupMetaService {
	protected static final Logger logger = Logger
			.getLogger(GroupMetaServiceImpl.class);
	@Autowired
	@Qualifier("groupMetaRepository")
	GroupMetaRepository groupMetaRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<GroupMetaEntity> getGroupMetaNames() {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaServiceImpl..calling  groupMetaRepository.getGroupMetaNames()");
		List<GroupMetaEntity> groupNames= groupMetaRepository.getGroupMetaNames();
		logger.info("GroupValues :"+groupNames.get(0)+".."+groupNames.get(1));
		return groupMetaRepository.getGroupMetaNames();
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public long addNewGroupValues(GroupMetaBean groupMetaBean) {
		// TODO Auto-generated method stub
		GroupMetaEntity groupMetaEntity=new GroupMetaEntity();
		groupMetaEntity.setGroupMetaId(groupMetaBean.getGroupMetaId());
		groupMetaEntity.setGroupName(groupMetaBean.getGroupName());
		return groupMetaRepository.addNewGroupValues(groupMetaEntity);
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GroupMetaBean> searchGroupValues() {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaServiceImpl  searchGroupValues()...");
		List<GroupMetaEntity> groupMetaEntityList=new ArrayList<GroupMetaEntity>();
		List<GroupMetaBean> groupMetaBeansList=new ArrayList<GroupMetaBean>();
		groupMetaEntityList= groupMetaRepository.searchGroupValues();
		logger.info("calling createGroupMetaBeans(groupMetaEntityList)...");
		groupMetaBeansList=createGroupMetaBeans(groupMetaEntityList);
		return groupMetaBeansList;
	}
	//creating List of metaBeansList from List of GroupMetaEntity
	public List<GroupMetaBean> createGroupMetaBeans(List<GroupMetaEntity> groupMetaEntities){
		logger.info("@GroupMetaSevice.. enteed into createGroupMetaBeans()");
	List<GroupMetaBean> metaBeansList=new ArrayList<GroupMetaBean>();
	for(GroupMetaEntity metaEntity:groupMetaEntities){
		GroupMetaBean bean=new GroupMetaBean();
		bean.setGroupMetaId(metaEntity.getGroupMetaId());
		bean.setGroupName(metaEntity.getGroupName());
		metaBeansList.add(bean);
	}
	return metaBeansList;
}
	/* (non-Javadoc)
	 * @see com.avalon.ftp.services.meta.GroupMetaService#editGroupValueByID(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public GroupMetaBean editGroupValueByID(long groupMetaId) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaServiceImpl  editGroupValueByID()...");
		GroupMetaBean groupMetaBean=new GroupMetaBean();
		GroupMetaEntity groupMetaEntity=groupMetaRepository.editGroupValueByID(groupMetaId);
		groupMetaBean.setGroupMetaId(groupMetaEntity.getGroupMetaId());
		groupMetaBean.setGroupName(groupMetaEntity.getGroupName());
		return groupMetaBean;
	}
	/* (non-Javadoc)
	 * @see com.avalon.ftp.services.meta.GroupMetaService#getGroupValueById(long)
	 */
	public GroupMetaEntity getGroupValueById(long groupMetaId) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaServiceImpl  getGroupValueById()");
		return groupMetaRepository.getGroupValueById(groupMetaId);
	}
	//updating the editted record values.
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateGroupValue(GroupMetaBean groupMetaBean) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaServiceImpl  updateGroupValue()...calling getGroupValueById()");
		//getting record with id
		GroupMetaEntity groupMetaEntity=getGroupValueById(groupMetaBean.getGroupMetaId());
		//updating the fetched record with editted values
		groupMetaEntity.setGroupMetaId(groupMetaBean.getGroupMetaId());
		groupMetaEntity.setGroupName(groupMetaBean.getGroupName());
		logger.info("@GroupMetaServiceImpl  updateGroupValue()");
		groupMetaRepository.updateGroupValue(groupMetaEntity);
	}
	/* (non-Javadoc)
	 * @see com.avalon.ftp.services.meta.GroupMetaService#deleteGroupValueByID(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteGroupValueByID(long groupMetaId) {
		// TODO Auto-generated method stub
		logger.info("@GroupMetaServiceImpl  deleteGroupValueByID()..");

		groupMetaRepository.deleteGroupValueByID(groupMetaId);
		
	}
	
	
	

}
