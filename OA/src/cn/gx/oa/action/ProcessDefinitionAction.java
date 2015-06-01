package cn.gx.oa.action;

import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.gx.oa.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;
@Component
@Scope("prototype")
public class ProcessDefinitionAction extends BaseAction<Object> {
	private File upload;
	private String uploadFileName;
	private String key;
	private InputStream inputStream;
	private String id;

	public String list() throws Exception {
		List<ProcessDefinition> processDefinitionList=processService.findAllLastVersion();
		ActionContext.getContext().put("processDefinitionList",processDefinitionList);
		return "list";
	}
	public String addUI() throws Exception {
		
		return "addUI";
	}
	public String add() throws Exception {
		System.out.println(uploadFileName);
		System.out.println(upload.getName());
		processService.deploy(upload);
		return "tolist";
	}
	/**
	 * 因为需要删除所有版本，所以选择它的key
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		key=URLDecoder.decode(key,"UTF-8");
		processService.deleteByKey(key);
		return "tolist";
	}
	public String downProcessImage() throws Exception {
		inputStream = processService.downImage(id);
		return "downImage";
	}
	
	//setter和getter方法
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
}
