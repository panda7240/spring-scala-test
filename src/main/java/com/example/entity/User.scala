package com.example.entity

import scala.beans.BeanProperty

//class User (
//    @BeanProperty var name: String, 
//    @BeanProperty var age: Int,
//    @BeanProperty var flag: Boolean
//)

case class User() {
  
  @BeanProperty
  var name: String = "";
  
  @BeanProperty
  var age : Int = 0;
  
  @BeanProperty
  var flag: Boolean = false;
  
  def this(name: String, age: Int, flag: Boolean) = {
    this();
    this.name = name;
    this.age = age;
    this.flag = flag;
  }
  
}