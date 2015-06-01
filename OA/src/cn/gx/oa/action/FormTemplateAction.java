package cn.gx.oa.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.FormTemplate;
import cn.gx.oa.util.FileUtils;

import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class FormTemplateAction extends BaseAction<FormTemplate> {
	private File upload;
	private InputStream inputStream;
	private String fileName;
	
	public String list() throws Exception {
		List<FormTemplate> ftlist= formTemplateService.findAll();
		ActionContext.getContext().put("ftlist", ftlist);
		return "list";
	}
	public String addUI() throws Exception {
		List<ProcessDefinition> pdlist = processService.findAllLastVersion();
		ActionContext.getContext().put("pdlist", pdlist);
		return "saveUI";
	}
	public String add() throws Exception {
		String path =FileUtils.saveUploadFile(upload); 
		model.setPath(path);
		formTemplateService.add(model);
		return "tolist";
	}
	
	public String editUI() throws Exception {
		FormTemplate formTemplate=formTemplateService.findById(model.getId());
		List<ProcessDefinition> pdlist = processService.findAllLastVersion();
		ActionContext.getContext().put("pdlist", pdlist);		
		ActionContext.getContext().getValueStack().push(formTemplate);		
		return "saveUI"; 
	}
	public String edit() throws Exception {
		FormTemplate formTemplate=formTemplateService.findById(model.getId());
		File file=new File(formTemplate.getPath());
		if(upload!=null){
			file.delete();
			String path=FileUtils.saveUploadFile(upload);
			formTemplate.setPath(path);
		}
		formTemplate.setName(model.getName());
		formTemplate.setProcessKey(model.getProcessKey());
		formTemplateService.edit(formTemplate);
		return "tolist";
	}
	public String delete() throws Exception {	
		FormTemplate formTemplate=formTemplateService.findById(model.getId());
		File file=new File(formTemplate.getPath());
		file.delete();
		formTemplateService.delete(model.getId());	
		return "tolist";
	}
	public String download() throws Exception {		
		FormTemplate formTemplate=formTemplateService.findById(model.getId());
		File file=new File(formTemplate.getPath());
		inputStream=new FileInputStream(file);
		fileName=formTemplate.getName();
		return "download";
	}
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
