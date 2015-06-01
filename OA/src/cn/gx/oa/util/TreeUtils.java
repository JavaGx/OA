package cn.gx.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.gx.oa.domain.Department;

public class TreeUtils {
	
	public static List<Department> getTree(List<Department> topList){
		List<Department> list=new ArrayList<Department>();
		getTreeList(topList,"",list);
		return list;
	}
	
	private static void getTreeList(Collection<Department> topList,String s,List<Department> list){
		 
		for(Department dept:topList){
			Department d=new Department();
			d.setId(dept.getId());
			d.setName(s+"┣"+dept.getName());
			list.add(d);
			List<Department> children=new ArrayList<Department>(dept.getDepts()); 
			getTreeList(children,"　"+s,list);
		}
	}
}
