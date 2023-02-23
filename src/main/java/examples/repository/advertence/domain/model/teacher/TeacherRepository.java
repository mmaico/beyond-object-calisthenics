package examples.repository.advertence.domain.model.teacher;

import java.util.Optional;

public interface TeacherRepository {

    Optional<Teacher> findOne(Long id);
}
