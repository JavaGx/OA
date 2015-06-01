package cn.gx.oa.service;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.Forum;
import cn.gx.oa.domain.Topic;

public interface ForumService extends BaseDao<Forum> {

	void moveUp(Long id);

	void moveDown(Long id);

}
