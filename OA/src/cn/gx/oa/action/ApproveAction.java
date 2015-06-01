package cn.gx.oa.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Approve;
import cn.gx.oa.domain.Form;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ApproveAction extends BaseAction<Approve> {
	private Long formId;
	private String taskId;
	
	public String list(){
		List<Approve> list=approveService.findApproveByFormId(formId);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	
	public String approveUI(){
		return "approveUI";
	}
	
	public String submit(){
		Form form=approveService.findForm(formId);
		model.setForm(form);
		model.setApproveTime(new Date());
		model.setApproval(getUser().getUsername());
		approveService.submit(taskId,model);
		return "submit";
	}

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}
