package examples.repository.teachers.certification.domain.model.teacher;

import examples.repository.infrastructure.ServiceLocator;
import examples.repository.teachers.certification.domain.model.certificatiion.CertificationRepository;
import examples.repository.teachers.certification.domain.model.certificatiion.Certifications;

public class Teacher {

    private CertificationRepository repository;

    public Teacher() {
        this.repository = ServiceLocator.getBean(CertificationRepository.class);
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Certifications findAllMyCertification() {
        return this.repository.findBy(this);
    }
}
