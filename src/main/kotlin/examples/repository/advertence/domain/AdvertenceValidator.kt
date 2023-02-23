package examples.repository.advertence.domain


import examples.repository.advertence.domain.model.Advertence
import examples.repository.advertence.domain.model.director.DirectorRepository
import examples.repository.advertence.domain.model.student.StudentRepository
import examples.repository.advertence.domain.model.teacher.TeacherRepository
import examples.repository.infrastructure.Helpers


class AdvertenceValidator(val teacherRepository: TeacherRepository,
                          val directorRepository: DirectorRepository,
                          val studentRepository: StudentRepository) {



    val `for new advertence`: Helpers.Validation<Advertence> = Helpers.Validation {
        rule { "Student is not found" } verify { studentRepository.findOne(received?.id).isEmpty }
        rule { "Director is not found" } verify { directorRepository.findOne(appliedBy.id).isEmpty }
        rule { "Teacher is not found" } verify { teacherRepository.findOne(classOf.id).isEmpty }

    }

    val `for update advertence`: Helpers.Validation<Advertence> = Helpers.Validation {
        //...
    }
}
