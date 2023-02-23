package examples.repository.notification.system.application;

import examples.repository.notification.system.domain.model.Notification;

;

public interface NotificationFacade {

    void send(Notification notification);
}
