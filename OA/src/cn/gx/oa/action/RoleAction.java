package cn.gx.oa.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Privilege;
import cn.gx.oa.domain.Role;

import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	
	private Long[] privilegeIds;
	
	public String add() throws Exception{
		rService.add(getModel());
		return "tolist";
	}
	public String addUI(){
		return "saveUI";
	}
	public String delete(){
		rService.delete(getModel().getId());
		return "tolist";
	}
	public String edit(){
		Role r=rService.findById(getModel().getId());
		r.setName(getModel().getName());
		r.setDescription(getModel().getDescription());
		rService.edit(r);
		return "tolist";
	}
	public String editUI(){
		Role role=rService.findById(getModel().getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	public String list(){
		List<Role> list=rService.findAll();
		ActionContext.getContext().put("list",list);
		return "list";
	}
	
	public String setPrivilegeUI(){
		Role r=rService.findById(getModel().getId());
		ActionContext.getContext().getValueStack().push(r);
		List<Privilege> plist=new ArrayList<Privilege>(r.getPrivileges());
		privilegeIds=new Long[plist.size()];
		int index=0;
		for(Privilege p:plist){
			privilegeIds[index]=p.getId();
			index++;
		}
		return "privilegeUI";
	}
	
	public String setPrivilege(){
		Role r=rService.findById(getModel().getId());
		List<Privilege> plist=pService.findPrivilegesByIds(privilegeIds);
		r.setPrivileges(new HashSet<Privilege>(plist));		
		rService.edit(r);
		return "tolist";
	}
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
	
}
