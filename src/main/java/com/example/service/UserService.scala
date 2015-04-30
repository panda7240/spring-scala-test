package com.example.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.entity.User
import com.example.jpa.UserRepository
import javax.persistence.Entity
import javax.persistence.Table
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specification

@Service
class UserService {
  
  @Autowired
  var userRepository: UserRepository = _
  
  def addUser(user: User) = {
    userRepository.save(user)
  }
  
  def findAll(pageRequest: PageRequest):Page[User] = {
    userRepository.findAll(pageRequest)
  }
  
  def findAll(spec: Specification[User], pageRequest: PageRequest):Page[User] = {
    userRepository.findAll(spec, pageRequest);
  }

}