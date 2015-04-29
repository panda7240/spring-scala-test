package com.example.controller.scala

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import com.example.entity.User
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ScalaController {
  
  var log = LoggerFactory.getLogger(this.getClass)
  
  /**
   * @return String
   */
  @RequestMapping(value = Array("/scala"), method = Array(RequestMethod.GET))
  @ResponseBody
  def helloScala() = {
    "Hello Scala";
  }
  
  /**
   * @return User
   */
  @RequestMapping(value = Array("/user"), method = Array(RequestMethod.GET))
  @ResponseBody
  def helloUser() = {
    log.info("----Print HelloUser!");
    new User("liujx", 25, true);
  }
  
  /**
   * @param name
   * @return user
   */
  @RequestMapping(Array("/user/{name}"))
  @ResponseBody
  def param(@PathVariable("name") name: String, session: HttpSession) = {
    var user = new User(name, 1, false);
    log.info(user.toString());
    session.setAttribute("user", user);
    user
  }
  
  @RequestMapping(Array("/user/request"))
  @ResponseBody
  def session(request: HttpServletRequest, response: HttpServletResponse, session: HttpSession) = {
    val age = request.getParameter("age").toInt;
    session.getAttribute("user") match {
      case null => new User("xxx", 0 , false);
      case u: User => {u.setAge(age); u} 
    }
  } 
 
  
}