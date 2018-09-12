package cloud_servce.entity.gifjia;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Cacheable(true)
@Table(name="gifjia_tags")
@Entity
public class GifjiaTags {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tagId;
	private String 	tagName;
	private String 	tagDis;
	private String 	tagNum;
	private String 	tagHref;
	private String 	tagDisHref;
	@JsonIgnore // 排除序列化
	private String 	identification;
	private Integer 	isNew;
	
	public GifjiaTags() {
		// TODO 自动生成的构造函数存根
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagDis() {
		return tagDis;
	}

	public void setTagDis(String tagDis) {
		this.tagDis = tagDis;
	}

	public String getTagNum() {
		return tagNum;
	}

	public void setTagNum(String tagNum) {
		this.tagNum = tagNum;
	}

	public String getTagHref() {
		return tagHref;
	}

	public void setTagHref(String tagHref) {
		this.tagHref = tagHref;
	}

	public String getTagDisHref() {
		return tagDisHref;
	}

	public void setTagDisHref(String tagDisHref) {
		this.tagDisHref = tagDisHref;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

}
