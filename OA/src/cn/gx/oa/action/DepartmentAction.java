package cn.gx.oa.action;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Department;
import cn.gx.oa.util.TreeUtils;

import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	private Long parentId;
	
	public String add() throws Exception{
		Department parent=dService.findById(parentId);
		getModel().setParent(parent);

		dService.add(getModel());
		return "tolist";
	}
	public String addUI(){		
		List<Department> depts=dService.topList();
		List<Department> dList=TreeUtils.getTree(depts);
		ActionContext.getContext().put("list", dList);
		return "saveUI";
	}
	public String delete(){
		dService.delete(getModel().getId());
		return "tolist";
	}
	public String edit(){
		Department parent=dService.findById(parentId);
		Department dept=dService.findById(getModel().getId());
		dept.setName(getModel().getName());
		dept.setDescription(getModel().getDescription());
		dept.setParent(parent);
		dService.edit(dept);
		return "tolist";
	}
	public String editUI(){		
		List<Department> list=TreeUtils.getTree(dService.topList());
		ActionContext.getContext().put("list",list);
		Department dept=dService.findById(getModel().getId());
		ActionContext.getContext().getValueStack().push(dept);
		return "saveUI";
	}
	public String list(){
		if(parentId==null){
			List<Department> list=dService.topList();
			ActionContext.getContext().put("list",list);
			return "list";
		}else{
			List<Department> list=dService.findLower(parentId);
			Department dept=dService.findById(parentId);
			ActionContext.getContext().put("parent",dept);
			ActionContext.getContext().put("list",list);
			return "list_level2";
		}
		
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
