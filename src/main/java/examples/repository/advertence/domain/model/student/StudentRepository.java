package examples.repository.advertence.domain.model.student;

import java.util.Optional;

public interface StudentRepository {

    Optional<Student> findOne(Long id);
}
