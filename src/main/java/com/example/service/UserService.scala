package com.example.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.example.entity.User
import com.example.jpa.UserRepository

import javax.persistence.Entity
import javax.persistence.Table

@Service
class UserService {
  
  @Autowired
  var userRepository: UserRepository = _
  
  def addUser(user: User) {
    userRepository.save(user);
  }

}