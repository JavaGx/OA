package cn.gx.oa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FormTemplate implements Serializable {
	private Long id;
	private String name;
	private String processKey;
	private String path;
	private Set<Form> forms=new HashSet<Form>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Set<Form> getForms() {
		return forms;
	}
	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
	
}
