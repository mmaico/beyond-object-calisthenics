package examples.repository.notification.email.domain.model;

import examples.repository.infrastructure.http.ValidationException;
import org.apache.commons.validator.routines.EmailValidator;

public class To {

    private String to;

    public To(String to) {
        if (EmailValidator.getInstance().isValid(to)) {
            throw new ValidationException("Invalid email from: " + to);
        }
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
