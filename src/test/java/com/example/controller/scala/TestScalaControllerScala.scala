package com.example.controller.scala

import com.example.AbstractControllerTest
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.http.MediaType

class TestScalaControllerScala extends AbstractControllerTest{

  @Test
  def testHelloScala() {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/scala").accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  def testHelloUser() {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/user").accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  def testParam() {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/user/liujx").accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  def testSession() {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/user/request").param("age", "10").accept(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  def testAddUser() {
    val content: String = """ {"name":"liujx","age":25,"flag":true} """;
    this.mockMvc.perform(MockMvcRequestBuilders.post("/user/add").contentType(MediaType.APPLICATION_JSON).content(content))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  
}