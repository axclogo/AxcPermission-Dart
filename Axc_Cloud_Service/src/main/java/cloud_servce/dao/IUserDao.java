package cloud_servce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cloud_servce.entity.User;
 

public interface IUserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{
    User findByUserId(Integer user_id);
    User findByUserPhone(String user_phone);
    User findByUserPhoneAndUserPassword(String user_phone, String user_password);
}
