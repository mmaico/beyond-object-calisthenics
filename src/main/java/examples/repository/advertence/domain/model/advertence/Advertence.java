package examples.repository.advertence.domain.model.advertence;

import examples.repository.advertence.domain.model.director.Director;
import examples.repository.advertence.domain.model.student.Student;
import examples.repository.advertence.domain.model.teacher.Teacher;
import examples.repository.infrastructure.ServiceLocator;

public class Advertence {
    private Long id;
    private Director appliedBy;
    private Student received;
    private Teacher classOf;

    private AdvertenceRepository repository;

    public Advertence() {
        this.repository = ServiceLocator.getBean(AdvertenceRepository.class);
    }

    public Advertence save() {
        return this.repository.save(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Director getAppliedBy() {
        return appliedBy;
    }

    public void setAppliedBy(Director appliedBy) {
        this.appliedBy = appliedBy;
    }

    public Student getReceived() {
        return received;
    }

    public void setReceived(Student received) {
        this.received = received;
    }

    public Teacher getClassOf() {
        return classOf;
    }

    public void setClassOf(Teacher classOf) {
        this.classOf = classOf;
    }
}
