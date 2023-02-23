package examples.repository.advertence.domain.model.comunications;

import examples.repository.advertence.domain.model.advertence.Advertence;
import examples.repository.infrastructure.ServiceLocator;

public class Comunication {

    private Advertence advertence;
    private ComunicationRepository repository;


    public Comunication(Advertence advertence) {
        this.advertence = advertence;
        this.repository = ServiceLocator.getBean(ComunicationRepository.class);
    }

    public static Comunication comunication(Advertence advertence) {
        return new Comunication(advertence);
    }

    public  void send() {
        this.repository.send(this);
    }

    public Advertence getAdvertence() {
        return advertence;
    }
}
