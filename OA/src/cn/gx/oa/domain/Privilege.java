package cn.gx.oa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Privilege  implements Serializable{
	
	private Long id;
	private String name;
	private String url;
	private Privilege parentPri;
	private Set<Privilege> childrenPri =new HashSet<Privilege>();	
	private Set<Role> roles=new HashSet<Role>();	
	

	public Privilege() {
	}

	public Privilege(String name, String url, Privilege parentPri) {
		super();
		this.name = name;
		this.url = url;
		this.parentPri = parentPri;
	}
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Privilege getParentPri() {
		return parentPri;
	}
	public void setParentPri(Privilege parentPri) {
		this.parentPri = parentPri;
	}
	public Set<Privilege> getChildrenPri() {
		return childrenPri;
	}
	public void setChildrenPri(Set<Privilege> childrenPri) {
		this.childrenPri = childrenPri;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
