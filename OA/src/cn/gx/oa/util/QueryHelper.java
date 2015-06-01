package cn.gx.oa.util;

public class QueryHelper {
	
	private static String hql;
	/**
	 * 根据主题类型条件拼接查询语句
	 * @param viewType
	 * @return 查询条件字符串
	 */
	public static String queryViewType(int viewType){
		String conditon1;
		if(viewType==1){
			conditon1=" and t.type=1";
		}else{
			return "";
		}
		return conditon1;
	}
	/**
	 * 根据条件排序拼接查询语句
	 * @param viewType
	 * @return 排序语句字符串
	 */
	public static String queryOrder(int orderBy,boolean reverse){
		String condition2;
		if(orderBy==1){
			condition2=" order by t.updateTime "+(reverse?"ASC":"DESC");
		}else if(orderBy==2){
			condition2=" order by t.createTime "+(reverse?"ASC":"DESC");
		}else if(orderBy==3){
			condition2=" order by t.replyCount "+(reverse?"ASC":"DESC");
		}else{
			return " order by (case t.type when 2 then 2 else 0 end) DESC,t.updateTime DESC";
		}
		
		return condition2;
	}
	
}
