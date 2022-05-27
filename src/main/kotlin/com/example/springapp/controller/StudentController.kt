package com.example.springapp.controller

import com.example.springapp.dto.StudentDto
import com.example.springapp.model.Student
import com.example.springapp.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class StudentController @Autowired constructor(
    private val studentService: StudentService
) {
    @GetMapping("/students/list")
    @ResponseBody
    fun getStudentList(): List<StudentDto> {
        return studentService.getStudentList()
    }

    @GetMapping("/students/{sid}")
    @ResponseBody
    fun getById(@PathVariable("sid") id: Long): StudentDto {
        return studentService.getById(id)
    }

    @PostMapping("/students")
    @ResponseBody
    fun save(@RequestBody dto: StudentDto): Student {
        return studentService.save(dto)
    }

    @DeleteMapping("/students/{sid}")
    fun delete(@PathVariable("sid") id: Long): ResponseEntity<*> {
        return studentService.delete(id)
    }
}
