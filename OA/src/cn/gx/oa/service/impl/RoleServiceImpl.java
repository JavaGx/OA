package cn.gx.oa.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Privilege;
import cn.gx.oa.domain.Role;
import cn.gx.oa.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl extends BaseDaoImpl<Role> implements RoleService {
	
		
	public List<Role> findRolesByIds(Long[] roleIds) {
		List<Role> rlist=new ArrayList<Role>();
		for(Long id:roleIds){
			Role role=findById(id);
			rlist.add(role);
		}
		return rlist;
	}

	public List<Privilege> findAllPrivilege() {
		List<Privilege> plist=getSession().createQuery("from Privilege").list();
		return plist;
	}
	
}
