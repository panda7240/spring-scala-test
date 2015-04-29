package com.example.controller.scala;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.AbstractControllerTest;

public class TestScalaController extends AbstractControllerTest{

	@Test
	public void testHelloScala() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/scala").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testHelloUser() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/user").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testParam() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/user/liujx").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testSession() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/user/request").param("age", "10").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());
	}
	
}
