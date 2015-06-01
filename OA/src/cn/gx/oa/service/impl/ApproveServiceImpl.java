package cn.gx.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Approve;
import cn.gx.oa.domain.Form;
import cn.gx.oa.service.ApproveService;

@Service
@Transactional
public class ApproveServiceImpl extends BaseDaoImpl<Approve> implements
		ApproveService {
	@Resource
	private ProcessEngine processEngine;
	
	public List<Approve> findApproveByFormId(Long formId) {
		List<Approve> approveList=getSession().createQuery("from Approve a where a.form.id=?")
										.setParameter(0, formId).list();
		return approveList;
	}

	public Form findForm(Long formId) {
		
		return (Form)getSession().createQuery("from Form f where f.id=?")
		.setParameter(0, formId).uniqueResult();
	}

	public void submit(String taskId,Approve model) {
		Task task=processEngine.getTaskService().getTask(taskId);
		if("同意".equals(model.getIsApprove())){
			processEngine.getTaskService().completeTask(taskId);
			ProcessInstance pi=processEngine.getExecutionService()
					.createProcessInstanceQuery()
					.processInstanceId(task.getExecutionId())
					.uniqueResult();
			if(pi==null){
				model.getForm().setStatus("已通过");
			}
		}else{
			processEngine.getExecutionService().endProcessInstance(task.getExecutionId(), "ended");
			model.getForm().setStatus("未通过");
		}
		this.add(model);
	}

}
