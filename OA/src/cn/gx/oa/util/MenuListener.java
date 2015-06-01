package cn.gx.oa.util;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.gx.oa.domain.Privilege;
import cn.gx.oa.service.PrivilegeService;

public class MenuListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent arg0) {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		SessionFactory factory=(SessionFactory) context.getBean("sessionFactory");
		 
		List<Privilege> plist=factory.openSession().createQuery("from Privilege p where p.parentPri.id is null").list();
		arg0.getServletContext().setAttribute("topMenu",plist);
		
		PrivilegeService pService=(PrivilegeService)context.getBean("privilegeServiceImpl");
		List<String> urls=pService.findUrl();
		arg0.getServletContext().setAttribute("urls",urls);
	}

}
