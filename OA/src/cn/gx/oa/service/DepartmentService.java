package cn.gx.oa.service;

import java.util.List;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.Department;

public interface DepartmentService extends BaseDao<Department> {

	List<Department> topList();

	List<Department> findLower(Long parentId);

}
