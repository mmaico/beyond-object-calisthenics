package examples.repository.notification.email.application;

import examples.repository.notification.email.domain.model.Email;

public interface EmailFacade {

    void send(Email email);
}
