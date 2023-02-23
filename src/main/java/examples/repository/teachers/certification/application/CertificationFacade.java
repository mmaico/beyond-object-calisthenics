package examples.repository.teachers.certification.application;

import examples.repository.teachers.certification.domain.model.certificatiion.Certification;
import examples.repository.teachers.certification.domain.model.teacher.Teacher;

import java.util.Collection;

public interface CertificationFacade {

    Collection<Certification> findBy(Teacher teacher);
}
