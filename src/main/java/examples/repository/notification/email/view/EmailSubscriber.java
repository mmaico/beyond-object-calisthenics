package examples.repository.notification.email.view;

import com.google.common.eventbus.Subscribe;
import examples.repository.infrastructure.messages.EmailMessage;
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
    public void sendEmail(EmailMessage emailMessage) {
        var email = new Email();
        email.setFom(new From(emailMessage.getFrom()));
        email.setTo(new To(emailMessage.getTo()));
        email.setSubject(emailMessage.getSubject());
        email.setTemplate(emailMessage.getTemplate());

        facade.send(email);
    }

}
