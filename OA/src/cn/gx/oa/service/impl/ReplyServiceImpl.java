package cn.gx.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.Forum;
import cn.gx.oa.domain.PageBean;
import cn.gx.oa.domain.Reply;
import cn.gx.oa.domain.Topic;
import cn.gx.oa.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImpl extends BaseDaoImpl<Reply> implements ReplyService {

	@Override
	public void add(Reply entity) {
		entity.setCreateTime(new Date());
		Topic topic=entity.getTopic();
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReply(entity);
		topic.setUpdateTime(entity.getCreateTime());
		Forum forum=topic.getForum();
		forum.setArticleCount(forum.getArticleCount()+1);
		getSession().save(entity);
		//getSession().update(forum);
	}

	public PageBean findReplyByTopicId(Long id,int num) {
		int count=this.findCountByCondition("select count(*) from Reply r where r.topic.id="+id);
		List replies=getSession().createQuery("from Reply r where r.topic.id=?")
		.setParameter(0, id)
		.setFirstResult((num-1)*10)
		.setMaxResults(10).list();
		return new PageBean(num,count,replies);
	}


}
