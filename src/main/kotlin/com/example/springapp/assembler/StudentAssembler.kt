package com.example.springapp.assembler

import com.example.springapp.dto.StudentDto
import com.example.springapp.model.Student
import org.springframework.stereotype.Component

@Component
class StudentAssembler {
    fun toModel(dto: StudentDto): Student {
        val student = Student()
        student.firstName = dto.firstName
        student.lastName = dto.lastName
        student.klass = dto.klass
        return student
    }

    fun toDto(model: Student): StudentDto {
        return StudentDto(
            model.id,
            model.firstName,
            model.lastName,
            model.klass
        )
    }
}