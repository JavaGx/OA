package cn.gx.oa.service;

import java.util.List;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.Privilege;
import cn.gx.oa.domain.Role;


public interface RoleService extends BaseDao<Role>{

	List<Role> findRolesByIds(Long[] roleIds);

	List<Privilege> findAllPrivilege();
	
}
