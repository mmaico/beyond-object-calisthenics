package examples.repository.advertence.application

import examples.repository.advertence.domain.AdvertenceValidator
import examples.repository.advertence.domain.model.Advertence
import examples.repository.infrastructure.validate


class AdvertenceApplicationKt(val rules: AdvertenceValidator): AdvertenceFacadeKt {



    override fun apply(advertence: Advertence): Advertence {
        advertence.validate(rules.`for new advertence`)

        val director = advertence.appliedBy
        val teacher = advertence.classOf
        val student = advertence.received

        return director appliesA advertence toThe student fromTheClassOf teacher
    }

}