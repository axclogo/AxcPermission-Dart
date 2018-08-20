package com.test.model;

import java.util.List;
 
public class NewTotal {
	private int total; //新闻数量
	private List<News> rows; //新闻列表
	
	
	public NewTotal() {
	}
	public NewTotal(int total, List<News> rows) {
		this.total = total;
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
