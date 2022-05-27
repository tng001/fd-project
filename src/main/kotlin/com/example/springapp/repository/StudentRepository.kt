package com.example.springapp.repository

import com.example.springapp.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Long> {
    fun findByFirstNameLike(firstName: String): List<Student>?
}
