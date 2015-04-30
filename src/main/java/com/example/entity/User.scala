package com.example.entity

import scala.beans.BeanProperty
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.GenerationType

@Entity
@Table(name = "my_user")
case class User() {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _
  
  @Column
  @BeanProperty
  var name: String = _
  
  @Column
  @BeanProperty
  var age : Int = _
  
  @Column
  @BeanProperty
  var flag: Boolean = _
  
  def this(name: String, age: Int, flag: Boolean) = {
    this()
    this.name = name
    this.age = age
    this.flag = flag
  }
  
}



