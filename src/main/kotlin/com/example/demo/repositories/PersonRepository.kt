package com.example.demo.repositories

import com.example.demo.models.Person
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
interface PersonRepository : MongoRepository<Person, String> {
    fun findByName (@Param("name") name: String): List<Person>
}