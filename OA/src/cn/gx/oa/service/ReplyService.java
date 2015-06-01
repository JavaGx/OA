package cn.gx.oa.service;


import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.PageBean;
import cn.gx.oa.domain.Reply;

public interface ReplyService extends BaseDao<Reply> {

	PageBean findReplyByTopicId(Long id,int num);
	
}
