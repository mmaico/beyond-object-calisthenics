package examples.repository.teachers.certification.infrastructure;

import com.google.common.collect.Lists;
import examples.repository.teachers.certification.domain.model.certificatiion.Certification;
import examples.repository.teachers.certification.domain.model.certificatiion.CertificationRepository;
import examples.repository.teachers.certification.domain.model.certificatiion.Certifications;
import examples.repository.teachers.certification.domain.model.certificatiion.Type;
import examples.repository.teachers.certification.domain.model.teacher.Teacher;
import org.springframework.stereotype.Repository;

@Repository("certificationRepository")
public class CertificatiionRepositoryDB implements CertificationRepository {


    @Override
    public Certifications findBy(Teacher teacher) {
        var certificationOne = new Certification();
        certificationOne.setId(1l);
        certificationOne.setType(Type.NATIONAL);
        certificationOne.setOwner(teacher);

        var certificationTwo = new Certification();
        certificationTwo.setId(2l);
        certificationTwo.setType(Type.NATIONAL);
        certificationTwo.setOwner(teacher);

        var certificationThree = new Certification();
        certificationTwo.setId(3l);
        certificationTwo.setType(Type.INTERNATIONAL);
        certificationTwo.setOwner(teacher);

        return new Certifications(Lists.newArrayList(certificationOne, certificationTwo, certificationThree));
    }
}
