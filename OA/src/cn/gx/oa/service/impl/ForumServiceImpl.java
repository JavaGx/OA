package cn.gx.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Forum;
import cn.gx.oa.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements ForumService{

	public void moveUp(Long id) {

		Forum forum = (Forum)getSession().get(Forum.class, id);
		Forum upForum = (Forum) getSession().createQuery("from Forum f where f.position<? order by f.position DESC")
			.setParameter(0,forum.getPosition())
				.setMaxResults(1)
				.setFirstResult(0).uniqueResult();
		if(upForum!=null){
			int temp=upForum.getPosition();
			upForum.setPosition(forum.getPosition());
			forum.setPosition(temp);
			getSession().update(forum);			
			getSession().update(upForum);
		}
	}
	
	public void moveDown(Long id) {
		Forum forum = (Forum)getSession().get(Forum.class, id);
		Forum upForum = (Forum) getSession().createQuery("from Forum f where f.position>? order by f.position ASC")
			.setParameter(0,forum.getPosition())
				.setMaxResults(1)
				.setFirstResult(0).uniqueResult();
		if(upForum!=null){
			int temp=upForum.getPosition();
			upForum.setPosition(forum.getPosition());
			forum.setPosition(temp);
			getSession().update(forum);			
			getSession().update(upForum);
		}
	}

	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("from Forum f order by f.position").list();
	}
	
	
}
