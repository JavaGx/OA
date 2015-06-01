package cn.gx.oa.domain;

import java.io.Serializable;
import java.util.Date;

import org.jbpm.api.task.Task;

public class ApproveView implements Serializable {
	private Long id;
	private Form form;
	private String taskId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}
