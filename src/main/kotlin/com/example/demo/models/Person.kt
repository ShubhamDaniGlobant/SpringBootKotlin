package com.example.demo.models

import org.springframework.data.annotation.Id

data class Person(@Id val id: String, val name: String)

