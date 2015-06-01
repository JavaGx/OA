package cn.gx.oa.base;

import java.util.List;

public interface BaseDao<T> {
	
	void add(T entity);
	void delete(Long id);
	void edit(T entity);
	List<T> findAll();
	T findById(Long id);
	int findCountByCondition(String hql);
}
