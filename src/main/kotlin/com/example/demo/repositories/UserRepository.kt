package com.example.demo.repositories

import com.example.demo.Entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>