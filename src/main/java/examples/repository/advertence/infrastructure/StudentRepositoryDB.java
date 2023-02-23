package examples.repository.advertence.infrastructure;

import examples.repository.advertence.domain.model.student.Student;
import examples.repository.advertence.domain.model.student.StudentRepository;
import examples.repository.advertence.domain.model.teacher.Teacher;
import examples.repository.advertence.infrastructure.dao.UserProfile;
import examples.repository.advertence.infrastructure.dao.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentRepositoryDB implements StudentRepository {

    private UserRepository repository;

    public StudentRepositoryDB(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public Optional<Student> findOne(Long id) {
        var result = repository.findOne(id, UserProfile.STUDENT.getId());
        return result.isPresent() ? Optional.of(new Student(result.get().getId())) : Optional.empty();
    }
}
