package cn.gx.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Forum;
import cn.gx.oa.domain.PageBean;
import cn.gx.oa.domain.Topic;
import cn.gx.oa.service.TopicService;
@Service
@Transactional
public class TopicServiceImpl extends BaseDaoImpl<Topic> implements TopicService {

	@Override
	public void add(Topic entity) {
		entity.setCreateTime(new Date());
		entity.setUpdateTime(entity.getCreateTime());
		Forum forum=entity.getForum();
		forum.setArticleCount(forum.getArticleCount()+1);
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setLastTopic(entity);
		getSession().save(entity);
	}

	public PageBean findPageByForumId(Long forumId, int num,String queryType,String queryOrder) {
		int count=this.findCountByCondition("select count(*) from Topic t where t.forum.id="+forumId+queryType);
		List topics=getSession().createQuery("from Topic t where t.forum.id=?"+queryType+queryOrder)
		.setMaxResults(10)
		.setFirstResult((num-1)*10)
		.setParameter(0, forumId).list();
		return new PageBean(num,count,topics);
		
	}

	
}
