package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.model.Tuser;
import com.example.demo.service.TuserService;

@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Resource
	private TuserService tuerService;
	
	 @Autowired
	 private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
	    mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void contextLoads() {
		Tuser tuser=new Tuser();
		tuser.setName("wangwu");
		tuser.setPassword("123456");
		tuerService.seve(tuser);
	}
	 @Test
	 public void getHello() throws Exception {
	     mvc.perform(MockMvcRequestBuilders.get("/hello/world"))
	             .andExpect(MockMvcResultMatchers.status().isOk())
	             .andDo(MockMvcResultHandlers.print())
	             .andReturn();
	 }
	 @Test
	 public void getHelloworle() throws Exception {
		 mvc.perform(MockMvcRequestBuilders.get("/tuser/getUser").accept(MediaType.APPLICATION_JSON))
		 .andExpect(MockMvcResultMatchers.status().isOk())
		 .andDo(MockMvcResultHandlers.print())
		 .andReturn();
	 }

	 
	 private String url = "http://localhost:8080/";
		
		
		public String getdate(){
			Date date = new Date();
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			return time;
		}
		
		
		/*@Test
		public void selectCalluses(){
			
		
			try {
					 HttpResponse<String> asString = Unirest.post(url+"helloc").asString();
					//System.out.println(jsonResponse.getBody().toString());
					System.out.println(asString.getBody().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	 
}
