package com.example.springapp.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "STUDENT")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    var id: Long = 0

    @Column(name = "FIRST_NAME", nullable = false)
    lateinit var firstName: String

    @Column(name = "LAST_NAME", nullable = false)
    lateinit var lastName: String

    @Column(name = "CLASS", nullable = false)
    var klass: Int = 0
}