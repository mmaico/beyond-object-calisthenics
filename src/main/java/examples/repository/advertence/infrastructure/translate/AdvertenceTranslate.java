package examples.repository.advertence.infrastructure.translate;

import examples.dao.entity.AdvertenceEntity;
import examples.dao.entity.UserEntity;
import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.director.Director;
import examples.repository.advertence.domain.model.student.Student;
import examples.repository.advertence.domain.model.teacher.Teacher;
import org.springframework.stereotype.Component;

@Component
public class AdvertenceTranslate {

    public AdvertenceEntity fromModel(Advertence advertence) {
        final AdvertenceEntity entity = new AdvertenceEntity();
        entity.setDirector(new UserEntity(advertence.getAppliedBy().getId()));
        entity.setStudant(new UserEntity(advertence.getReceived().getId()));
        entity.setTeacher(new UserEntity(advertence.getClassOf().getId()));
        return entity;
    }

    public Advertence toModel(AdvertenceEntity entitySaved) {
        final Advertence advertence = new Advertence();
        advertence.setId(entitySaved.getId());
        advertence.setAppliedBy(new Director(entitySaved.getDirector().getId()));
        advertence.setClassOf(new Teacher(entitySaved.getTeacher().getId()));
        advertence.setReceived(new Student(entitySaved.getStudant().getId()));

        return advertence;
    }
}
