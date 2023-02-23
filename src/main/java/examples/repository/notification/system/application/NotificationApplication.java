package examples.repository.notification.system.application;

import examples.repository.notification.system.domain.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationApplication implements NotificationFacade {

    @Override
    public void send(Notification notification) {
        //TODO implementar o envio da notificacao
    }
}
