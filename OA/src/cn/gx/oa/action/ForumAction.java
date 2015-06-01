package cn.gx.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Forum;

@Component
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {
	
	public String list(){
		List<Forum> flist=fService.findAll();
		ActionContext.getContext().put("flist", flist);
		return "list";
	}
	
}
