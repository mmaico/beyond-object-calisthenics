package examples.repository.notification.email.domain.model;


import examples.repository.infrastructure.http.ValidationException;
import org.apache.commons.validator.routines.EmailValidator;

public class From {

    private String from;

    public From(String from) {
        if (EmailValidator.getInstance().isValid(from)) {
            throw new ValidationException("Invalid email from: " + from);
        }
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
