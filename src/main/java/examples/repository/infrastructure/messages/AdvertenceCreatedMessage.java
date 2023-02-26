package examples.repository.infrastructure.messages;

import examples.repository.advertence.domain.model.advertence.Advertence;

public class AdvertenceCreatedMessage {

    private Advertence advertence;

    public AdvertenceCreatedMessage(Advertence advertence) {
        this.advertence = advertence;
    }


    public Advertence getAdvertence() {
        return advertence;
    }

    public void setAdvertence(Advertence advertence) {
        this.advertence = advertence;
    }
}
