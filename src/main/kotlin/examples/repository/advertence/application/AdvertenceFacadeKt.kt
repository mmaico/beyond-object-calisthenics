package examples.repository.advertence.application

import examples.repository.advertence.domain.model.Advertence


interface AdvertenceFacadeKt {

    fun apply(advertence: Advertence): Advertence
}