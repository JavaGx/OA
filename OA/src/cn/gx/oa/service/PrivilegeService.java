package cn.gx.oa.service;

import java.util.List;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.Privilege;

public interface PrivilegeService extends BaseDao<Privilege>{
	List<Privilege> findPrivilegesByIds(Long[] privilegeIds);

	List<String> findUrl();
}
