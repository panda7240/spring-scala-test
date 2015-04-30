package com.example.jpa

import com.example.entity.User
import javax.persistence.Entity
import javax.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository

trait UserRepository extends JpaRepository[User, java.lang.Long]{}