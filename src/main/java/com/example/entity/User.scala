package com.example.entity

import scala.beans.BeanProperty
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.GenerationType
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.Root
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import org.springframework.data.repository.query.parser.PartTree.Predicate
import javax.persistence.criteria.Predicate
import scala.collection.JavaConversions._

@Entity
@Table(name = "my_user")
case class User() extends Specification[User]{
  
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
  
  def toPredicate(root :Root[User], query :CriteriaQuery[_], cb :CriteriaBuilder ) :Predicate = {
    var pId: Predicate = cb.equal(root.get("id").asInstanceOf, this.getId())
    var pName: Predicate = cb.like(root.get("name").asInstanceOf, "%" + this.getName() + "%")
    query.where(pId, pName)
    
    pName
  }
  
}



