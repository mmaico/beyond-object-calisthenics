package examples.repository.notification.system.view;

import com.google.common.eventbus.Subscribe;
import examples.repository.infrastructure.messages.NotificationMessage;
import examples.repository.notification.system.application.NotificationFacade;
import examples.repository.notification.system.domain.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationSubscriber {

    private NotificationFacade facade;

    public NotificationSubscriber(NotificationFacade facade) {
        this.facade = facade;
    }

    @Subscribe
    public void send(NotificationMessage notificationMessage) {
        Notification notification = new Notification();
        //notificationMessage converter para notification
        facade.send(notification);
    }
}
