package com.example.demo.controllers

import com.example.demo.Entity.User

import com.example.demo.models.BaseResponseModel
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping(path = ["/getAllUser"])
    @ResponseBody
    fun getUser() = BaseResponseModel(responseModel =  userRepository.findAll().sortedBy { user -> user.id })


    @GetMapping(path = ["/saveuser"])
    @ResponseBody
    fun saveUser(@RequestParam name: String, @RequestParam email: String): BaseResponseModel {
        userRepository.save(User(name = name, email = email))
        return BaseResponseModel(responseModel = "user saved")
    }

    @PostMapping(path = ["/saveuserbyPost"])
    @ResponseBody
    fun saveuserbyPost(@RequestBody user: User): BaseResponseModel {
        userRepository.save(user)
        return BaseResponseModel(responseModel = "user saved by post")
    }

    @DeleteMapping(path = ["/delete/{id}"])
    @ResponseBody
    fun delete(@PathVariable(value = "id") id: Int = -1): BaseResponseModel {
        if (id == -1) {
            return BaseResponseModel(responseModel = "user does not exist")
        }
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            return BaseResponseModel(responseModel = "user deleted")
        }
        return BaseResponseModel(responseModel = "user does not exist")
    }

    @PutMapping(path = ["/update/{id}"])
    @ResponseBody
    fun update(@PathVariable(value = "id") id: Int = -1, @RequestBody updatedUser: User): BaseResponseModel {

        val userSaved = userRepository.findById(id).get()
        userSaved.name = updatedUser.name
        userSaved.email = updatedUser.email
        userRepository.save(userSaved)

        return BaseResponseModel(responseModel = "User updated")
    }
}