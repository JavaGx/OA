package cn.gx.oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Reply;
import cn.gx.oa.domain.Topic;
@Component
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {
	private Long topicId;
	
	public String addUI(){
		Topic topic=tService.findById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}
	public String add(){
		Topic topic=tService.findById(topicId);
		model.setTopic(topic);
		model.setAuthor(getUser());
		replyService.add(model);
		return "show";
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
