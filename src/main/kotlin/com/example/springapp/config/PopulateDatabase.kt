package com.example.springapp.config

import com.example.springapp.model.Student
import com.example.springapp.repository.StudentRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.concurrent.ThreadLocalRandom
import java.util.stream.IntStream

@Component
class PopulateDatabase @Autowired constructor(
    private val studentRepo: StudentRepository
) : ApplicationRunner {
    var logger: Logger = LoggerFactory.getLogger(PopulateDatabase::class.java)

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        logger.debug("Populating the database with 20K Dummy Records ... In Progress")
        val students: MutableList<Student> = ArrayList()
        IntStream.range(1, 20000).forEach { id: Int ->
            val student = Student()
            student.firstName = "f$id"
            student.lastName = "l$id"
            val randomClass = ThreadLocalRandom.current().nextInt(1, 12 + 1)
            student.klass = randomClass
            students.add(student)
        }
        studentRepo.saveAll(students)
        logger.debug("Database filled up!")
    }
}
