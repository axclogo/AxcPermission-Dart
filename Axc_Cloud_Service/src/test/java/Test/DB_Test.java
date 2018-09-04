package Test;

import java.util.*;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cloud_servce.entity.*;
import test_class.TestBase;

public class DB_Test extends TestBase {

	public DB_Test() {
        System.out.println("开始");

		  //1. 创建 EntitymanagerFactory
        String persistenceUnitName = "jpaDemo";

        Map<String, Object> properites = new HashMap<String, Object>();
        properites.put("hibernate.show_sql", true);

        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory(persistenceUnitName, properites);

        //2. 创建 EntityManager. 类似于 Hibernate 的 SessionFactory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3. 开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        System.out.println("开启完成");

        //4. 进行持久化操作
        test customer = new test();
        customer.setTest_id(12);
        customer.setTest_name("name");
        customer.setTest_dis("test_dis");

        entityManager.persist(customer);

        //5. 提交事务
        transaction.commit();

        //6. 关闭 EntityManager
        entityManager.close();

        //7. 关闭 EntityManagerFactory
        entityManagerFactory.close();
		
        System.out.println("完成");
	}


}
// public void testDate(){
//  Refund refund = new Refund();
//  refund.setContent("haha");
//  refund.setOrderId((long) 233);
//  refund = refundDao.save(refund);
//  System.out.println(JsonUtil.object2JsonString(refund));
// }