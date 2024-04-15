package it.polito.test1.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
@Entity
class Course(
    var name: String,
): BaseEntity() {

    @ManyToMany
    val students: MutableSet<Student> = mutableSetOf()

    fun addStudent(s: Student) {
        students.add(s)
    }
}