package examples.repository.teachers.certification.domain.model.certificatiion;

import examples.repository.teachers.certification.domain.model.teacher.Teacher;

public interface CertificationRepository {

    Certifications findBy(Teacher teacher);
}
