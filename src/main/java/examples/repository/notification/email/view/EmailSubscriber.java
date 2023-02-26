package examples.repository.notification.email.view;

import com.google.common.eventbus.Subscribe;
import examples.repository.infrastructure.messages.AdvertenceCreatedMessage;
import examples.repository.notification.email.application.EmailFacade;
import examples.repository.notification.email.domain.model.Email;
import examples.repository.notification.email.domain.model.From;
import examples.repository.notification.email.domain.model.To;
import org.springframework.stereotype.Component;

@Component
public class EmailSubscriber {

    private EmailFacade facade;

    public EmailSubscriber(EmailFacade facade) {
        this.facade = facade;
    }

    @Subscribe
    public void sendEmail(AdvertenceCreatedMessage message) {
        var email = new Email();
        //TODO montar o objeto de dominio a partir do message

        facade.send(email);
    }

}
