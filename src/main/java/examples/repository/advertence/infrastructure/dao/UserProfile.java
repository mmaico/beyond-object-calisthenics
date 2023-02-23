package examples.repository.advertence.infrastructure.dao;

public enum UserProfile {

    TEACHER(1l), DIRECTOR(2l), STUDENT(3l), PARENTS(4l);

    private Long id;

    UserProfile(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
