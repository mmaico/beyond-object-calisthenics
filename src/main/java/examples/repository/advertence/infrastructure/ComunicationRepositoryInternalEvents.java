package examples.repository.advertence.infrastructure;

import com.google.common.eventbus.EventBus;
import examples.repository.advertence.domain.model.comunications.Comunication;
import examples.repository.advertence.domain.model.comunications.ComunicationRepository;
import examples.repository.infrastructure.messages.EmailMessage;
import examples.repository.infrastructure.messages.NotificationMessage;
import org.springframework.stereotype.Component;

@Component("comunicationRepository")
public class ComunicationRepositoryInternalEvents implements ComunicationRepository {

    private EventBus eventBus;

    public ComunicationRepositoryInternalEvents(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void send(Comunication comunication) {
        //TODO usar o comucation object para preencher o emailMessa e o NotificationMessage
        eventBus.post(new EmailMessage());
        eventBus.post(new NotificationMessage());
    }
}
