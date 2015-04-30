package com.example.entity

import scala.beans.BeanProperty

//class User (
//    @BeanProperty var name: String, 
//    @BeanProperty var age: Int,
//    @BeanProperty var flag: Boolean
//)

case class User() {
  
  @BeanProperty
  var name: String = _
  
  @BeanProperty
  var age : Int = _
  
  @BeanProperty
  var flag: Boolean = _
  
  def this(name: String, age: Int, flag: Boolean) = {
    this()
    this.name = name
    this.age = age
    this.flag = flag
  }
  
}