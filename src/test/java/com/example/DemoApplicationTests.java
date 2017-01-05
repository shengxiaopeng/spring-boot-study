package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		System.out.println("-----hello-------");

	}

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public  void setupMockMvc(){
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public  void homePage() throws Exception{


		mockMvc.perform(MockMvcRequestBuilders.get("/index111"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public  void  test1(){
		RestTemplate restTemplate=new RestTemplate();
		String forObject = restTemplate.getForObject("http://www.baidu.com", String.class);

		System.out.println(forObject);
	}

}
