package examples.repository.advertence.domain.model.teacher;

import examples.repository.advertence.domain.model.advertence.Advertence;

public class Teacher {
    private Long id;

    public Teacher(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @FunctionalInterface
    public static interface FromTheClassOf {
        public Advertence fromTheClassOf(Teacher teacher);
    }
}
