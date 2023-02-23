package examples.repository.advertence.domain.model.advertence;

import examples.repository.advertence.domain.model.director.DirectorRepository;
import examples.repository.advertence.domain.model.student.StudentRepository;
import examples.repository.advertence.domain.model.teacher.TeacherRepository;
import examples.repository.infrastructure.http.ValidationException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class AdvertenceValidator {

    private StudentRepository studentRepository;
    private DirectorRepository directorRepository;
    private TeacherRepository teacherRepository;

    public AdvertenceValidator(StudentRepository studentRepository, DirectorRepository directorRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.directorRepository = directorRepository;
        this.teacherRepository = teacherRepository;
    }

    private Map<String, CheckRule> rules = new HashMap<>();
    {
        rules.put("Student is not found", advertence -> !studentRepository.findOne(advertence.getReceived().getId()).isPresent());
        rules.put("Director is not found", advertence -> !directorRepository.findOne(advertence.getAppliedBy().getId()).isPresent());
        rules.put("Teacher is not found", advertence -> !teacherRepository.findOne(advertence.getClassOf().getId()).isPresent());
    }

    public void checkRules(Advertence advertence) {
        Optional<String> violations = rules.entrySet().stream()
                .filter(rule -> rule.getValue().check(advertence)).map(rule -> rule.getKey()).findFirst();

        if (violations.isPresent()) {
            throw new ValidationException(violations.get());
        }
    }

    private interface CheckRule {
        Boolean check(Advertence advertence);
    }
}
