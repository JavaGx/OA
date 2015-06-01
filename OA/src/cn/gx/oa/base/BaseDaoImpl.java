package cn.gx.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz=(Class<T>) type.getActualTypeArguments()[0];
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void add(T entity) {
		Session session=getSession();
		session.save(entity);
	}

	public void delete(Long id) {
		getSession().delete(findById(id));
	}

	public void edit(T entity) {
		getSession().update(entity);
	}

	public List<T> findAll() {
		Session session=getSession();
		List<T> list=session.createQuery("from "+clazz.getSimpleName()).list();
		return list;
	}

	public T findById(Long id) {
		if(id==null){
			return null;
		}else{
			Session session=getSession();
			T entity=(T) session.get(clazz, id);
			return entity;
		}
		
	}

	public int findCountByCondition(String hql) {		
		Long id=(Long)getSession().createQuery(hql)
		.uniqueResult();
		return id.intValue();
	}

}
