package cloud_servce.entity;

import javax.persistence.Cacheable;
import javax.persistence.Table;

@SuppressWarnings("serial")


@Cacheable(true)
@Table(name="test_table")

public class test implements java.io.Serializable{
    private Integer test_id;
    private String 	test_name;
    private String 	test_dis;

	public test() {
		// TODO 自动生成的构造函数存根
	}
	public test(Integer test_id,String 	test_name,String 	test_dis) {
        super();
        this.test_id = test_id;
        this.test_name = test_name;
        this.test_dis = test_dis;
	}
	
	
	
	
	
	
	
	
	
	
	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getTest_dis() {
		return test_dis;
	}

	public void setTest_dis(String test_dis) {
		this.test_dis = test_dis;
	}

}
