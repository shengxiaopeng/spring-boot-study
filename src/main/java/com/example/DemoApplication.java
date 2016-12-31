package com.example;

import com.example.dao.CityMapper;
import com.example.dao.UserMapper;
import com.example.domain.City;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Value("${myName}")
	String myNmae;

	@Autowired
	UserMapper userMapper;

	@Autowired
	CityMapper cityMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String index(){
		return "hello Spring Boot "+myNmae;
	}

	@RequestMapping("/hello")
	String hello(){
		return  "<b>hello kwl</b>";
	}

	@RequestMapping("/hello1")
	@ResponseBody
	Bean1 hello1(){
		Bean1 bean1=new Bean1();
		bean1.setName("hello");
		return bean1;
	}

	@RequestMapping(value="/helloMyBatis")
	@ResponseBody
	String helloMyBatis(){
		/*Bean1 bean1=new Bean1();
		bean1.setName("hello");
		return bean1;*/
		User user=new User();
		user.setName("kwl love sxp");
		user.setType("love");

		userMapper.addUser(user);

		User byId = this.userMapper.findById(1);
		return byId==null?"not found":byId.getName();

	}

	@RequestMapping(value="/helloMyBatis2")
	@ResponseBody
	String helloMyBatis2(){

	    return    cityMapper.selectCityById(1).getName();

	}

	/**
	 * 添加数据源
	 *
	 * 配置文件中如下：
			 datasource.sxp.driverClassName=com.mysql.jdbc.Driver
			 datasource.sxp.url=jdbc:mysql://localhost:3306/test
			 datasource.sxp.username=root
			 datasource.sxp.password=sxp
	 * @return
     */
   @Bean
   @ConfigurationProperties(prefix = "datasource.sxp")
	DataSource datasource(){
	  return DataSourceBuilder.create().build();
   }




}
