package examples.repository.notification.email.application;

import examples.repository.notification.email.domain.model.Email;
import org.springframework.stereotype.Service;

@Service
public class EmailApplication implements EmailFacade {

    @Override
    public void send(Email email) {
        //TODO  implementar o envio
    }
}
