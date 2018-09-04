package cloud_servce.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Cacheable(true)
@Table(name="users")
@Entity
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String 	userName;
	
	@Column(name = "user_cover")
	private String 	userCover;
	
	@Column(name = "user_describe")
	private String 	userDescribe;

	@Column(name = "user_password")
	private String 	userPassword;
	
	@Column(name = "user_phone")
	private String 	userPhone;
	
	
	@Column(name = "user_level")
	private Integer 	userLevel;
	@Column(name = "isAdmin")
	private Integer 	isAdmin;


	public User() {
		// TODO 自动生成的构造函数存根
	}
	
	
	
	
	@Override
    public String toString() {
        return String.format(
                "User:[user_id=%d, user_name='%s', user_cover='%s', user_describe='%s', user_level='%d', is_admin='%d']",
                userId, userName, userCover,userDescribe,userLevel,isAdmin);
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
}
