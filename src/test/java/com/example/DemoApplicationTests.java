package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		System.out.println("-----hello-------");

	}

	/**
	 * 下面方法测试事务
     */
	@Autowired
	TransactionTest transactionTest;

	@Test
	public void  testTransaction(){

		//transactionTest.saveWithRollBack();
        transactionTest.saveWithoutRollBack();
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
