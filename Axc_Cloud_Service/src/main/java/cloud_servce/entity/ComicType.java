package cloud_servce.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Cacheable(true)
@Table(name="comicType")
@Entity
public class ComicType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer 	comicId;
	@JsonIgnore // 排除序列化
	private String 	comicType;
	private String 	comicDis;
	
	public ComicType() {
		// TODO 自动生成的构造函数存根
	}



	public Integer getComicId() {
		return comicId;
	}



	public void setComicId(Integer comicId) {
		this.comicId = comicId;
	}



	public String getComicType() {
		return comicType;
	}

	public void setComicType(String comicType) {
		this.comicType = comicType;
	}

	public String getComicDis() {
		return comicDis;
	}

	public void setComicDis(String comicDis) {
		this.comicDis = comicDis;
	}

}
