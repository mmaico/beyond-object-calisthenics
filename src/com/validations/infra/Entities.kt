package com.validations.infra

import java.math.BigDecimal
import java.util.*

data class Order(val id: String? = UUID.randomUUID().toString(),
                 val total: BigDecimal,
                 var customer: Customer?,
                 var seller: Seller?,
                 var coupon: Coupon?)

data class Customer(var id: String)

data class Seller(val id: String, val active: Boolean = false) {

    fun isActive() = this.active
}

data class Coupon(val id: String)