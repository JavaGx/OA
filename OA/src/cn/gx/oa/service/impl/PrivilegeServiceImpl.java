package cn.gx.oa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Privilege;
import cn.gx.oa.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeService {
	
	public List<Privilege> findPrivilegesByIds(Long[] privilegeIds) {
		List<Privilege> plist=new ArrayList<Privilege>();
		for(Long id:privilegeIds){
			Privilege privilege=findById(id);
			plist.add(privilege);
		}
		return plist;
	}

	public List<String> findUrl() {
		List<String> urls=getSession().createQuery("select p.url from Privilege p where p.url is not null").list();
		return urls;
	}
}
