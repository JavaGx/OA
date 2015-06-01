package cn.gx.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.jbpm.api.ProcessDefinition;

public interface ProcessService {

	List<ProcessDefinition> findAllLastVersion();

	void deploy(File upload);

	void deleteByKey(String key);

	InputStream downImage(String id);

}
