package cn.gx.oa.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ClientAction extends ActionSupport {
	
	public String right(){
		
		return "right";
	}
	
	public String left(){
		
		return "left";
	}
	
	public String top(){
		
		return "top";
	}
	
	public String bottom(){
		
		return "bottom";
	}

	public String index(){
		
		return "return index";
	}
	
}
