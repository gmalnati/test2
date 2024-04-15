package it.polito.test1.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
class Student(
    var firstName: String,
    var lastName: String,
): BaseEntity() {
    @ManyToMany(mappedBy = "students")
    val courses: MutableSet<Course> = mutableSetOf()

    fun addCourse(course: Course) {
        courses.add(course)
        course.students.add(this)
    }
}