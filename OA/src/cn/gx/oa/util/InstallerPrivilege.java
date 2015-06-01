package cn.gx.oa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gx.oa.domain.Privilege;



public class InstallerPrivilege {
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session=factory.openSession();

		Privilege menu2=new Privilege("审批流转",null,null);
		//session.save(new Privilege("审批流程管理",null,menu2));
		session.save(new Privilege("表单模板管理",null,menu2));
		session.save(new Privilege("起草申请",null,menu2));
		session.save(new Privilege("待我审批",null,menu2));
		session.save(new Privilege("我的申请查询",null,menu2));

		Privilege menu3=new Privilege("网上交流",null,null);
		session.save(new Privilege(" 论坛",null,menu3));
		session.save(new Privilege(" 论坛管理",null,menu3));
		
		
		Privilege menu1=new Privilege("系统管理",null,null);				
		session.save(new Privilege("部门管理","/department",menu1));
		session.save(new Privilege("部门列表","/department_list",menu1));
		session.save(new Privilege("部门添加","/department_add",menu1));
		session.save(new Privilege("部门删除","/department_delete",menu1));
		session.save(new Privilege("部门修改","/department_edit",menu1));
		
		session.save(new Privilege("岗位管理","/role",menu1));
		session.save(new Privilege("岗位列表","/role_list",menu1));
		session.save(new Privilege("岗位添加","/role_add",menu1));
		session.save(new Privilege("岗位删除","/role_delete",menu1));
		session.save(new Privilege("岗位修改","/role_edit",menu1));
		session.save(new Privilege("岗位设置权限","/role_setPrivilege",menu1));
		
		session.save(new Privilege("用户管理","/user",menu1));
		session.save(new Privilege("用户列表","/user_list",menu1));
		session.save(new Privilege("用户添加","/user_add",menu1));
		session.save(new Privilege("用户删除","/user_delete",menu1));
		session.save(new Privilege("用户修改","/user_edit",menu1));
		session.save(new Privilege("用户初始化密码","/user_intPwd",menu1));
	
	}
}
