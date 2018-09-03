package cloud_servce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages="{fabric.config}")
public class CloudServceApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(CloudServceApplication.class, args);
	}
	/**
     * 如果要发布到自己的Tomcat中的时候，需要继承SpringBootServletInitializer类，并且增加如下的configure方法。
     * 如果不发布到自己的Tomcat中的时候，就无需上述的步骤
     */
    @Override
	protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(CloudServceApplication.class);
    }
    
//    @PostConstruct
//    void setDefaultTimezone() {
//       TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
////     TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
//    }
}
