package cn.gx.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import cn.gx.oa.service.ProcessService;

@Service
public class ProcessServiceImpl implements ProcessService {
	@Resource
	private ProcessEngine processEngine;
	
	public List<ProcessDefinition> findAllLastVersion() {
		List<ProcessDefinition> all=processEngine.getRepositoryService().createProcessDefinitionQuery()
			.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION).list();
		Map<String,ProcessDefinition> map=new HashMap<String,ProcessDefinition>();
		for(ProcessDefinition pd:all){
			map.put(pd.getKey(), pd);
		}
		return new ArrayList<ProcessDefinition>(map.values());
	}

	public void deploy(File upload) {
		try {
			ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream(upload));
			processEngine.getRepositoryService().createDeployment()
				.addResourcesFromZipInputStream(zipInputStream)
				.deploy();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void deleteByKey(String key) {
		List<ProcessDefinition> all=processEngine.getRepositoryService().createProcessDefinitionQuery()
			.processDefinitionKey(key)
			.list();
		for(ProcessDefinition pd:all){
			processEngine.getRepositoryService().deleteDeploymentCascade(pd.getDeploymentId());
		}
	}

	public InputStream downImage(String id) {
		ProcessDefinition pd = processEngine.getRepositoryService().createProcessDefinitionQuery()
			.processDefinitionId(id)
			.uniqueResult();
		return processEngine.getRepositoryService().getResourceAsStream(pd.getDeploymentId(), pd.getImageResourceName());
		
	}

}
