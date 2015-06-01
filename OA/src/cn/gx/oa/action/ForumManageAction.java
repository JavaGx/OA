package cn.gx.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Forum;
@Component
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {
	
	public String list(){
		List<Forum> list=fService.findAll();
		ActionContext.getContext().put("forumList", list);
		return "list";
	}
	
	public String addUI(){
		
		return "saveUI";
	}
	
	public String add(){
		fService.add(getModel());
		int position=getModel().getId().intValue();
		getModel().setPosition(position);
		fService.edit(getModel());
		return "tolist";
	}
	
	public String editUI(){
		Forum forum=fService.findById(getModel().getId());
		ActionContext.getContext().getValueStack().push(forum);
		return "saveUI";
	}
	
	public String edit(){
		Forum forum=fService.findById(getModel().getId());
		forum.setName(getModel().getName());
		forum.setDescription(getModel().getDescription());
		fService.edit(forum);
		return "tolist";
	}
	
	public String delete(){
		fService.delete(getModel().getId());
		return "tolist";
	}
	
	public String moveUp(){
		fService.moveUp(getModel().getId());
		return "tolist";
	}
	
	public String moveDown(){
		fService.moveDown(getModel().getId());
		return "tolist";
	}
}
