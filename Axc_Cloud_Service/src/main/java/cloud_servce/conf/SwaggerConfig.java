package cloud_servce.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				/* .tags 第一个参数必须是Tag，后面的是 Tag 类型的可选参数
            new Tag(String,String) 第一个参数是key，第二个参数是Value。注解@Api#tags传入的是tag的key */
				.tags(new Tag("99_test", "测试接口"),getTags())
				.select()  // 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("cloud_servce.api")) // 对所有api进行监控
				.paths(PathSelectors.any()) // 对所有路径进行监控
				.build();
	}

	private Tag[] getTags() {
		Tag[] tags = {
				new Tag("0_user", "用户相关接口"),
				new Tag("1_crawler", "爬虫数据表接口"),
				new Tag("gold", ""),
				new Tag("wor1d", "分词接口"),
				new Tag("98_tripartite", "三方数据平台"),
		};
		return tags;
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Axc Cloud Api List")
				.description("Axc云开放Api平台")
				.termsOfServiceUrl("axclogo.club")
				.contact(new Contact("赵新", "axclogo.club", "axclogo@163.com"))
				.version("1.0")
				.build();
	}

}