package examples.repository.teachers.certification.domain.model.certificatiion;

import examples.repository.teachers.certification.domain.model.teacher.Teacher;

public class Certification {

    private Long id;
    private Type type;
    private Teacher owner;
    private Expired expired;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Teacher getOwner() {
        return owner;
    }

    public void setOwner(Teacher owner) {
        this.owner = owner;
    }

    public Expired getExpired() {
        return expired;
    }

    public void setExpired(Expired expired) {
        this.expired = expired;
    }
}
