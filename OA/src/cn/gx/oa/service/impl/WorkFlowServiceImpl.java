package cn.gx.oa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.ApproveView;
import cn.gx.oa.domain.Form;
import cn.gx.oa.domain.User;
import cn.gx.oa.service.WorkFlowService;

@Service
@Transactional
public class WorkFlowServiceImpl extends BaseDaoImpl<Object> implements WorkFlowService {
	
	@Resource
	private ProcessEngine processEngine;
	
	public void submit(String processKey, Form form) {
		form.setStatus("审批中");
		this.add(form);
		Map<String,Form> map=new HashMap<String, Form>();
		map.put("form", form);
		ProcessInstance pi=processEngine.getExecutionService()
										.startProcessInstanceByKey(processKey, map);
		Task task=processEngine.getTaskService().createTaskQuery()
					.executionId(pi.getId()).uniqueResult();
		processEngine.getTaskService().completeTask(task.getId());
		
	}

	public List<Form> findAllForm() {
		List<Form> formList=getSession().createQuery("from Form").list();
		return formList;
	}
	
	public List<ApproveView> findPersonalTask(User user) {
		List<Task> taskList=processEngine.getTaskService().createTaskQuery()
					.assignee(user.getUsername())
					.list();
		List<ApproveView> approveViewList=new ArrayList<ApproveView>();
		for(Task task:taskList){
			ApproveView approveView=new ApproveView();
			Form form=(Form)processEngine.getExecutionService().getVariable(task.getExecutionId(), "form");
			approveView.setForm(form);
			approveView.setTaskId(task.getId());
			approveViewList.add(approveView);
		}
		return approveViewList;
	}
	
	
}
