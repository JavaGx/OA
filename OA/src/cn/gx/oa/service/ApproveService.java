package cn.gx.oa.service;

import java.util.List;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.Approve;
import cn.gx.oa.domain.Form;

public interface ApproveService extends BaseDao<Approve> {
	List<Approve> findApproveByFormId(Long formId);

	Form findForm(Long formId);

	void submit(String taskId,Approve model);
}
