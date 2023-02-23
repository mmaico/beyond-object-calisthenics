package examples.repository.advertence.domain.model.director;

import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.advertence.domain.model.student.Student;

public class Director {

    private Long id;

    public Director(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Director director() {
        return new Director(null);
    }

    public Student.ToThe appliesA(Advertence advertence) {
        return  student -> teacher -> advertence.save();
    }


}
