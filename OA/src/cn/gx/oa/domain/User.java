package cn.gx.oa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable {
	private Long id;
	private String LoginName;
	private String username;
	private String password;
	private String gender;
	private String phone;
	private String email;
	private String description;
	private Department department;
	private Set<Role> roles=new HashSet<Role>();
	
	
	public boolean getPrivilege(String name){
		User user=(User)ActionContext.getContext().getSession().get("user");
		Set<Role> roles=user.getRoles();
		List<String> pNames=new ArrayList<String>();
		for(Role role:roles){
			for(Privilege p:role.getPrivileges()){
				pNames.add(p.getName());
			}
		}
		if(pNames.contains(name)){
			return true;
		}else{
			return false;
		}
	} 
	
	
	public boolean findPrivilegeByUrl(String url){
		
		int endIndex=url.indexOf("?");
    	if(endIndex>-1){
        	url=url.substring(0, endIndex);
    	}
    	
    	if(url.endsWith("UI")){
    		url=url.substring(0, url.length()-2);
    	}
    	
		List<String> urlList =(List<String>) ActionContext.getContext().getApplication().get("urls");
    	if(!urlList.contains(url)){
    		return true;
    	}else{
			User user=(User)ActionContext.getContext().getSession().get("user");
			Set<Role> roles=user.getRoles();
			for(Role role:roles){
				for(Privilege p:role.getPrivileges()){
					if(url.equals(p.getUrl())){
						return true;
					}
				}
			}
			return false;
    	}
	}
	
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
