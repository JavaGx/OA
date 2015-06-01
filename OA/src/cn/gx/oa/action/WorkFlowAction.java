package cn.gx.oa.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.ApproveView;
import cn.gx.oa.domain.Form;
import cn.gx.oa.domain.FormTemplate;
import cn.gx.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class WorkFlowAction extends BaseAction<Object> {
	private Long ftid;
	
	public String formTemplateList(){
		List<FormTemplate> formTemplateList = formTemplateService.findAll();
		ActionContext.getContext().put("formTemplateList",formTemplateList);
		return "listFormTemplate";
	}
	
	public String submitUI(){
		FormTemplate formTemplate=formTemplateService.findById(ftid);
		return "submitUI";
	}

	public String submit(){
		FormTemplate formTemplate=formTemplateService.findById(ftid);
		User user=getUser();
		Form form=new Form();
		form.setFormTemplate(formTemplate);
		form.setApplicant(user.getUsername());
		form.setApplicateTime(new Date());
		String time=new SimpleDateFormat("yyyy-MM-dd").format(form.getApplicateTime());
		form.setTitle(formTemplate.getName()+user.getUsername()+time);
		workFlowService.submit(formTemplate.getProcessKey(),form);
		return "submit";
	}
	
	public String formList(){
		List<Form> formList=workFlowService.findAllForm();
		ActionContext.getContext().put("formList", formList);
		return "formList";
	}
	
	public String taskList(){
		List<ApproveView> approveViewList=workFlowService.findPersonalTask(getUser());
		ActionContext.getContext().put("approveViewList", approveViewList);
		return "taskList";
	}	
	
	
	public Long getFtid() {
		return ftid;
	}

	public void setFtid(Long ftid) {
		this.ftid = ftid;
	} 
	
	
}
