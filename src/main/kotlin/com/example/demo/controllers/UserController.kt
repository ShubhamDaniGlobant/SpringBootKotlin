package com.example.demo.controllers

import com.example.demo.Entity.User
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.persistence.Id


@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping(path = ["/getAllUser"])
    @ResponseBody
    fun getAllUser(): Iterable<User> {
        return userRepository.findAll()
    }

    @GetMapping(path = ["/saveuser"])
    @ResponseBody
    fun saveUser(@RequestParam name: String, @RequestParam email: String) : String {
        val user = User(name = name, email = email)
        userRepository.save(user)
        return "user saved"
    }
}