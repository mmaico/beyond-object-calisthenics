package examples.repository.advertence.domain.model


data class Director(val id: Long) {
    infix fun appliesA(advertence: Advertence) = Student.ToThe { student ->
        Teacher.FromTheClassOf { teacher ->
            TODO("Not yet implemented")
        }
    }
}

data class Student(val id: Long) {
    fun interface ToThe {
        infix fun toThe(student: Student): Teacher.FromTheClassOf
    }
}
data class Teacher(val id: Long) {

    fun interface FromTheClassOf {
        infix fun fromTheClassOf(teacher: Teacher): Advertence
    }

}
data class Advertence(val id: Long, val appliedBy: Director, val classOf: Teacher, val received: Student)