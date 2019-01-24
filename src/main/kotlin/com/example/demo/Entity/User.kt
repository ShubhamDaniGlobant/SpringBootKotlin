package com.example.demo.Entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class User(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Int = 0, val name: String, val email: String) {

}
