package examples.repository.advertence.domain.model.student;

import examples.repository.advertence.domain.model.teacher.Teacher;

public class Student {

    private Long id;

    public Student(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @FunctionalInterface
    public static interface ToThe {
        Teacher.FromTheClassOf toThe(Student student);
    }
}
