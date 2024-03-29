package com.example.controller.scala

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod
import com.example.entity.User
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import org.springframework.beans.factory.annotation.Value
import org.slf4j.LoggerFactory
import org.springframework.boot.logging.logback.LogbackConfigurator
import com.example.service.UserService
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specifications
import org.springframework.data.jpa.domain.Specification

@RestController
class ScalaController {
  
  val log = LoggerFactory.getLogger(this.getClass)
  
  @Value("${app.name}")
  var appName: String = _
  
  @Value("${logging.file}")
  var logFileName: String = _
  
  @Autowired
  var userService: UserService = _
  
  /**
   * 测试字符串的返回
   * @return String
   */
  @RequestMapping(value = Array("/scala"), method = Array(RequestMethod.GET))
  @ResponseBody
  def helloScala() = {
    log.info("------------" + logFileName);
    "Hello " + appName;
  }
  
  /**
   * 测试对象返回
   * @return User
   */
  @RequestMapping(value = Array("/user"), method = Array(RequestMethod.GET))
  @ResponseBody
  def helloUser() = {
    log.info("----Print HelloUser!");
    new User("liujx", 25, true);
  }
  
  /**
   * 传递url参数
   * @param name
   * @return user
   */
  @RequestMapping(value = Array("/user/{name}"), method = Array(RequestMethod.GET))
  @ResponseBody
  def param(@PathVariable("name") name: String, session: HttpSession) = {
    var user = new User(name, 1, false);
    log.info(user.toString());
    userService.addUser(user);
    session.setAttribute("user", user);
    user
  }
  
  /**
   * 普通参数传递
   */
  @RequestMapping(value = Array("/user/request"), method = Array(RequestMethod.GET))
  @ResponseBody
  def session(request: HttpServletRequest, response: HttpServletResponse, session: HttpSession) = {
    val age = request.getParameter("age").toInt;
    session.getAttribute("user") match {
      case null => new User("xxx", 0 , false);
      case u: User => {u.setAge(age); u} 
    }
  }
  
  /**
   * post参数传递
   */
  @RequestMapping(value = Array("/user/add"), method = Array(RequestMethod.POST))
  @ResponseBody
  def addUser(@RequestBody user: User) = {
    log.info("===========" + user.age)
    user
  }
  
  /**
   * 分页查询
   * Pages are zero indexed , thus providing 0 for {@code page} will return the first
   */
  @RequestMapping(value = Array("/user/all/{page}/{size}"), method = Array(RequestMethod.GET))
  @ResponseBody
  def findAll(@PathVariable page: Int = 0, @PathVariable size: Int = 20) = {
    val pageRequest = new PageRequest(page, size)
    userService.findAll(pageRequest)
  }
  
  
  @RequestMapping(value = Array("/user/condition/{page}/{size}"), method = Array(RequestMethod.GET))
  @ResponseBody
  def findAllBy(@PathVariable page: Int = 0, @PathVariable size: Int = 20) = {   
    val userParam: User = new User()
    userParam.setName("liujx")
    userService.findAll(userParam, new PageRequest(page, size))
  }
  
}