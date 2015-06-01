package cn.gx.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.gx.oa.base.BaseAction;
import cn.gx.oa.domain.Forum;
import cn.gx.oa.domain.PageBean;
import cn.gx.oa.domain.Reply;
import cn.gx.oa.domain.Topic;
import cn.gx.oa.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
	
	private Long forumId;
	private int num=1;
	private int viewType;//0代表全部主题   1代表全部精华贴
	/**
	 * 0代表默认排序（按最后更新时间排序，但所有置顶帖都在前面）
	 * 1代表按最后更新时间排序
	 * 2代表按主题发表时间排序
	 * 3代表按回复数量排序
	 */
	private int orderBy;
	private boolean reverse;//false代表降序，true代表升序

	public String list(){
		Forum forum = fService.findById(forumId);
//		List<Topic> tlist=tService.findByForumId(forumId);
		PageBean bean=tService.findPageByForumId(forumId,num,QueryHelper.queryViewType(viewType),QueryHelper.queryOrder(orderBy, reverse));
		ActionContext.getContext().getValueStack().push(bean);
		ActionContext.getContext().put("forum", forum);
		return "list";
	}
	
	public String addUI(){
		Forum forum = fService.findById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	public String add(){
		Forum forum=fService.findById(forumId);
		model.setForum(forum);
		model.setAuthor(getUser());
		tService.add(model);
		ActionContext.getContext().put("topic", model);
		return "show";
	}
	
	public String show(){
		Topic topic=tService.findById(model.getId());
		ActionContext.getContext().put("topic", topic);
		PageBean bean=replyService.findReplyByTopicId(topic.getId(),num);
		ActionContext.getContext().getValueStack().push(bean);
		return "show";
	}
	
	public String edit(){
		Topic topic=tService.findById(model.getId());
		if(model.getType()!=topic.getType()){
			topic.setType(model.getType());
			tService.edit(topic);
		}
		forumId=topic.getForum().getId();
		return "tolist";
	}
	
	public String delete(){
		tService.delete(model.getId());
		return "tolist";
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}
		
}
