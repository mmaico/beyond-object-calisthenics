package examples.repository.advertence.infrastructure;

import examples.repository.advertence.domain.model.teacher.Teacher;
import examples.repository.advertence.domain.model.teacher.TeacherRepository;
import examples.repository.advertence.infrastructure.dao.UserProfile;
import examples.repository.advertence.infrastructure.dao.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TeacherRepositoryDB implements TeacherRepository {

    private UserRepository repository;

    public TeacherRepositoryDB(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Teacher> findOne(Long id) {
        var result = repository.findOne(id, UserProfile.TEACHER.getId());
        return result.isPresent() ? Optional.of(new Teacher(result.get().getId())) : Optional.empty();
    }
}
