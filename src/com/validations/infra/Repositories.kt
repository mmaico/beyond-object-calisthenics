package com.validations.infra

class CustomerRepository {

    companion object {
        val customers = hashMapOf(
                "1" to Customer("1"),
                "2" to Customer("2")
        )
    }

    fun findOne(id: String): Customer? = customers.get(id)
}

class SellerRepository {

    companion object {
        val sellers = hashMapOf(
                "1" to Seller("1", true),
                "2" to Seller("2", true)
        )
    }

    fun findOne(id: String): Seller? = sellers.get(id)
}

class CouponRepository {

    companion object {
        val coupons = hashMapOf(
                "1" to Coupon("1"),
                "2" to Coupon("2")
        )
    }

    fun findOne(id: String): Coupon? = coupons.get(id)
}

