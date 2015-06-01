package cn.gx.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Department;
import cn.gx.oa.service.DepartmentService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements
		DepartmentService {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	
	public List<Department> topList() {
		
		return getSession().createQuery("from Department d where d.parent.id is null").list();
	}


	public List<Department> findLower(Long parentId) {
		
		return getSession().createQuery("from Department d where d.parent.id = ?")
		
		.setParameter(0, parentId).list();
	}



}
