package cn.gx.oa.interceptor;


import cn.gx.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	

	public String intercept(ActionInvocation invocation) throws Exception {
		
		User user=(User)ActionContext.getContext().getSession().get("user");
		
		String namespace=invocation.getProxy().getNamespace();
		String actionName=invocation.getProxy().getActionName();
		String url=namespace+actionName;
		System.out.println(url);
		if(user==null){
			if(url.startsWith("/user_login")){
				return invocation.invoke();
			}else{
				return "loginUI";
			}
		}else{
			if(user.findPrivilegeByUrl(url)){
				return invocation.invoke();
			}else{
				return "noPrivilegeError";
			}
		}
	}

}
