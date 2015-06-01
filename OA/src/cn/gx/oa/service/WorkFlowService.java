package cn.gx.oa.service;

import java.util.List;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.Approve;
import cn.gx.oa.domain.ApproveView;
import cn.gx.oa.domain.Form;
import cn.gx.oa.domain.User;

public interface WorkFlowService extends BaseDao<Object> {

	void submit(String processKey, Form form);
	List<Form> findAllForm();
	
	List<ApproveView> findPersonalTask(User user);
}
