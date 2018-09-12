package cloud_servce.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Cacheable(true)
@Table(name="cnblogs")
@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer blogId;
	private String 	blogRecommend;
	private String 	blogHref;
	private String 	blogTitle;
	private String 	blogDis;
	private String 	blogAuthor;
	private String 	blogDate;
	private String 	onlyIdentification;
	
	public Blog() {
		// TODO 自动生成的构造函数存根
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogRecommend() {
		return blogRecommend;
	}

	public void setBlogRecommend(String blogRecommend) {
		this.blogRecommend = blogRecommend;
	}

	public String getBlogHref() {
		return blogHref;
	}

	public void setBlogHref(String blogHref) {
		this.blogHref = blogHref;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogDis() {
		return blogDis;
	}

	public void setBlogDis(String blogDis) {
		this.blogDis = blogDis;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public String getBlogDate() {
		return blogDate;
	}

	public void setBlogDate(String blogDate) {
		this.blogDate = blogDate;
	}

	public String getOnlyIdentification() {
		return onlyIdentification;
	}

	public void setOnlyIdentification(String onlyIdentification) {
		this.onlyIdentification = onlyIdentification;
	}

}
