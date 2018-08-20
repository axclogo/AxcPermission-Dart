package com.test.model;

public class AskListModel {

	public AskListModel() {
		// TODO 自动生成的构造函数存根
	}
	private String title; // 标题
	private String cover; // 图片URL
	private String date; // 

	private String tag; // 标签
	private String href_url; // 点击链接
	private String small; // 图片个数

	private String upload_user; // 上传者
	private String read_str; // 阅读
	private String comments; // 评论

	private String comments_url; // 评论链接
	private String like_str; // 点赞
	private String note; // 备注


	public AskListModel(
			String title, String cover, String date,
			String tag, String href_url, String small,
			String upload_user, String read_str, String comments,
			String comments_url, String like_str, String note
			) {
		this.title = title;
		this.cover = cover;
		this.date = date;
		this.tag = tag;
		this.href_url = href_url;
		this.small = small;
		this.upload_user = upload_user;
		this.read_str = read_str;
		this.comments = comments;
		this.comments_url = comments_url;
		this.like_str = like_str;
		this.note = note;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getHref_url() {
		return href_url;
	}

	public void setHref_url(String href_url) {
		this.href_url = href_url;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getUpload_user() {
		return upload_user;
	}

	public void setUpload_user(String upload_user) {
		this.upload_user = upload_user;
	}

	public String getRead_str() {
		return read_str;
	}

	public void setRead_str(String read_str) {
		this.read_str = read_str;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments_url() {
		return comments_url;
	}

	public void setComments_url(String comments_url) {
		this.comments_url = comments_url;
	}

	public String getLike_str() {
		return like_str;
	}

	public void setLike_str(String like_str) {
		this.like_str = like_str;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
