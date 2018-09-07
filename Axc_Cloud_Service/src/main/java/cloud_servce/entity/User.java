package cloud_servce.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Cacheable(true)
@Table(name="users")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//	@Column(name = "user_id")
	private Integer userId;
	private String 	userName;
	private String 	userCover;
	private String 	userDescribe;
	@JsonIgnore // password排除序列化
	private String 	userPassword;
	private String 	userPhone;
	private Integer 	userLevel;
	private Integer 	isAdmin;
	@JsonIgnore // 排除序列化
	private String 	service;

	public User() {
		// TODO 自动生成的构造函数存根
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCover() {
		return userCover;
	}

	public void setUserCover(String userCover) {
		this.userCover = userCover;
	}

	public String getUserDescribe() {
		return userDescribe;
	}

	public void setUserDescribe(String userDescribe) {
		this.userDescribe = userDescribe;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
	
}
