package com.direct.util;

import java.util.ArrayList;
import java.util.List;


public class PageModel<T> {
	private int currentPage;
	private int sumCount;
	private int size=3;
	private int sumPage;
	private List<T> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSumCount() {
		return sumCount;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
		
		sumPage=this.sumCount/this.size;
		if(this.sumCount%this.size!=0){
			sumPage++;
		}
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSumPage() {
		return sumPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
