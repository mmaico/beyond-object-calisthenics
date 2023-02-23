package examples.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name="advertences")
public class AdvertenceEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity teacher;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity director;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity studant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(UserEntity teacher) {
        this.teacher = teacher;
    }

    public UserEntity getDirector() {
        return director;
    }

    public void setDirector(UserEntity director) {
        this.director = director;
    }

    public UserEntity getStudant() {
        return studant;
    }

    public void setStudant(UserEntity studant) {
        this.studant = studant;
    }
}
