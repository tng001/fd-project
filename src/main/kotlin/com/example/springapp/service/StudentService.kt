package com.example.springapp.service

import com.example.springapp.assembler.StudentAssembler
import com.example.springapp.dto.StudentDto
import com.example.springapp.model.Student
import com.example.springapp.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.collections.ArrayList

@Component
class StudentService @Autowired constructor(
    private val studentRepo: StudentRepository,
    private val studentAssembler: StudentAssembler,
) {
    fun getStudentList(): List<StudentDto> {
        val studentsIterable: Iterable<Student> = studentRepo.findAll()
        val dtoList: MutableList<StudentDto> = ArrayList()
        studentsIterable.forEach {
            dtoList.add(studentAssembler.toDto(it))
        }
        return dtoList
    }

    fun getById(id: Long): StudentDto {
        val student: Optional<Student> = studentRepo.findById(id)
        return studentAssembler.toDto(nullCheck(student, id))
    }

    fun save(dto: StudentDto): Student {
        val student: Student = studentAssembler.toModel(dto)
        return studentRepo.save(student)
    }

    fun delete(id: Long): ResponseEntity<Any> {
        val existingStudent: Optional<Student> = studentRepo.findById(id)
        nullCheck(existingStudent, id)
        studentRepo.delete(existingStudent.get())
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    private fun nullCheck(student: Optional<Student>, id: Long): Student {
        return if (student.isPresent) {
            student.get()
        } else {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Student with id $id is not found.", null
            )
        }
    }
}