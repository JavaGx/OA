package cn.gx.oa.domain;

import java.util.List;

public class PageBean {
	private List recordList;
	private int currentPage=1;
	private int pageSize=10;
	private int count;
	private int beginPageIndex;
	private int endPageIndex;
	private int pageCount;
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public PageBean(int currentPage,int count,List recordList) {
		this.currentPage = currentPage;
		this.recordList=recordList;
		this.count=count;
		this.beginPageIndex =currentPage-4;
		this.endPageIndex=beginPageIndex+9;
		this.pageCount=(count+pageSize-1)/pageSize;
		
		if(count<pageSize){
			beginPageIndex=endPageIndex=1;
		}else{
			if(pageCount<pageSize){
				beginPageIndex=1;
				endPageIndex=pageCount;
			}else{
				if(currentPage<5){
					beginPageIndex=1;
					endPageIndex=beginPageIndex+9;
				}
				
				if(pageCount-currentPage<4){
					endPageIndex=pageCount;
					beginPageIndex=endPageIndex-9;
				}
			}
		}
		
		
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	
}
