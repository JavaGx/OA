package cn.gx.oa.service;


import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.PageBean;
import cn.gx.oa.domain.Topic;

public interface TopicService extends BaseDao<Topic> {

	
	PageBean findPageByForumId(Long id, int num,String queryType,String queryOrder);
}
