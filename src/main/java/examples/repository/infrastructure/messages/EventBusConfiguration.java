package examples.repository.infrastructure.messages;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import examples.repository.notification.email.view.EmailSubscriber;
import examples.repository.notification.system.view.NotificationSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class EventBusConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventBusConfiguration.class);


    private EmailSubscriber emailSubscriber;
    private NotificationSubscriber notificationSubscriber;

    public EventBusConfiguration(EmailSubscriber emailSubscriber, NotificationSubscriber notificationSubscriber) {
        this.emailSubscriber = emailSubscriber;
        this.notificationSubscriber = notificationSubscriber;
    }

    @Bean
    public EventBus eventBus() {
        var eventBus = new EventBus((throwable, context) ->
                LOGGER.error(throwable.getMessage()));

        eventBus.register(emailSubscriber);
        eventBus.register(notificationSubscriber);
        return eventBus;
    }

    @Bean
    public AsyncEventBus asyncEventBus() {
        var asyncEventBus = new AsyncEventBus(Executors.newCachedThreadPool(), (throwable, context) ->
                LOGGER.error(throwable.getMessage()));

        asyncEventBus.register(emailSubscriber);
        asyncEventBus.register(notificationSubscriber);
        return asyncEventBus;
    }
}