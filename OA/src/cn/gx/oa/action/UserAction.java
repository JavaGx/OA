package cn.gx.oa.action;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Department;
import cn.gx.oa.domain.Role;
import cn.gx.oa.domain.User;
import cn.gx.oa.util.MD5Utils;
import cn.gx.oa.util.TreeUtils;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
		
	private Long departmentId;
	private Long[] roleIds;
	
	
	public String add(){
		Department dept=dService.findById(departmentId);
		List<Role> rlist=rService.findRolesByIds(roleIds);
		getModel().setDepartment(dept);		
		getModel().setRoles(new HashSet<Role>(rlist));
		getModel().setPassword("1234");
		uService.add(getModel());
		return "tolist";
	}
	public String addUI(){
		List<Department> dlist=TreeUtils.getTree(dService.topList());
		ActionContext.getContext().put("dlist", dlist);
		List<Role> rlist=rService.findAll();
		ActionContext.getContext().put("rlist", rlist);
		return "saveUI";
	}
	
	public String delete(){
		uService.delete(getModel().getId());
		return "tolist";
	}
	public String editUI(){
		List<Department> dlist=TreeUtils.getTree(dService.topList());
		ActionContext.getContext().put("dlist", dlist);
		List<Role> rlist=rService.findAll();
		ActionContext.getContext().put("rlist", rlist);
		User user=uService.findById(getModel().getId());
		ActionContext.getContext().getValueStack().push(user);
		departmentId=user.getDepartment().getId();
		
		Set<Role> roles=user.getRoles();
		roleIds=new Long[roles.size()];
		for(int i=0;i<roles.size();i++){
			roleIds[i]=new ArrayList<Role>(roles).get(i).getId();
		}
		return "saveUI";
	}
	public String edit(){
		Department dept=dService.findById(departmentId);
		List<Role> rlist=rService.findRolesByIds(roleIds);
		
		User user=uService.findById(getModel().getId());
		user.setDepartment(dept);
		user.setRoles(new HashSet<Role>(rlist));
		user.setUsername(getModel().getUsername());
		user.setGender(getModel().getGender());
		user.setEmail(getModel().getEmail());
		user.setPhone(getModel().getPhone());
		user.setDescription(getModel().getDescription());		
		uService.edit(user);
		return "tolist";
	}
	public String list(){
		List<User> users=uService.findAll();
		ActionContext.getContext().put("users", users);
		return "list";
	}
	
	public String initPwd(){
		User user=uService.findById(getModel().getId());
		user.setPassword(MD5Utils.digest("1234"));
		uService.edit(user);
		return "tolist";
	}
	
	public String login(){
		User user=uService.findUserByLoginNameAndPwd(getModel().getLoginName(),getModel().getPassword());
		if(user!=null){			
			ActionContext.getContext().getSession().put("user",user);
			return "toIndex";
		}else{
			addFieldError("errorInfo","用户名或密码错误");
			return "loginUI";
		}
	}
	
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}

	
	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	

}
