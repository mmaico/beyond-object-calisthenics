package examples.repository.teachers.certification.application;

import examples.repository.teachers.certification.domain.model.certificatiion.Certification;
import examples.repository.teachers.certification.domain.model.certificatiion.Certifications;
import examples.repository.teachers.certification.domain.model.teacher.Teacher;

import java.util.Collection;

public class CertificationApplication implements CertificationFacade {

    @Override
    public Collection<Certification> findBy(Teacher teacher) {
        Certifications certifications = teacher.findAllMyCertification();

        return certifications;
    }
}
