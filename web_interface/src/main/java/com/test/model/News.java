package com.test.model;

import java.util.Date;

public class News {
 
	private int nId; // 新闻ID
	private String title; // 新闻标题
	private String content; // 新闻内容
	private String date; // 新闻发布日期
	private String url; //新闻地址
	private Date nDate; // 新闻日期，Date类型
 
	public News(int nId, String title, String content, String date, String url) {
		this.nId = nId;
		this.title = title;
		this.content = content;
		this.date = date;
		this.url = url;
	}
 
	public News() {
	}
 
	public News(int nId, String title, String content, Date nDate, String url) {
		this.nId = nId;
		this.title = title;
		this.content = content;
		this.nDate = nDate;
		this.url = url;
	}
 
	
	
	public String getUrl() {
		return url;
	}
 
	public void setUrl(String url) {
		this.url = url;
	}
 
	public Date getnDate() {
		return nDate;
	}
 
	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
 
	public int getnId() {
		return nId;
	}
 
	public void setnId(int nId) {
		this.nId = nId;
	}
 
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
 
	public String getContent() {
		return content;
	}
 
	public void setContent(String content) {
		this.content = content;
	}
 
	public String getDate() {
		return date;
	}
 
	public void setDate(String date) {
		this.date = date;
	}
 
}
