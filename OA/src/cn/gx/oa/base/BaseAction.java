package cn.gx.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.gx.oa.domain.User;
import cn.gx.oa.service.ApproveService;
import cn.gx.oa.service.DepartmentService;
import cn.gx.oa.service.FormTemplateService;
import cn.gx.oa.service.ForumService;
import cn.gx.oa.service.PrivilegeService;
import cn.gx.oa.service.ProcessService;
import cn.gx.oa.service.ReplyService;
import cn.gx.oa.service.RoleService;
import cn.gx.oa.service.TopicService;
import cn.gx.oa.service.UserService;
import cn.gx.oa.service.WorkFlowService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	protected T model;
	
	public T getModel() {		
		return model;
	}
	
	public User getUser(){
		return (User)ActionContext.getContext().getSession().get("user");
	}
	
	protected BaseAction(){
		try {
			ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();
			Class<T> clazz=(Class<T>)pt.getActualTypeArguments()[0];
			model=clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Resource
	protected RoleService rService;
	@Resource
	protected DepartmentService dService;
	@Resource
	protected UserService uService;
	@Resource
	protected PrivilegeService pService;
	@Resource
	protected ForumService fService;
	@Resource
	protected TopicService tService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected ProcessService processService;
	@Resource
	protected FormTemplateService formTemplateService;
	@Resource
	protected WorkFlowService workFlowService;
	@Resource
	protected ApproveService approveService;
}
