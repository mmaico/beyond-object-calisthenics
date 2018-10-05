package com.validations.examples.my_proposal

import com.validations.infra.*
import java.math.BigDecimal

class OrderValidationMyProposalKotlin(val customerRepository: CustomerRepository = CustomerRepository(),
                                      val sellerRepository: SellerRepository = SellerRepository(),
                                      val couponRepository: CouponRepository = CouponRepository()) {

    companion object {
        val MINIMUM_VALUE = BigDecimal(4)
    }

    val `for new order`: Validation<Order> = Validation {

        rule { "Order cannot be less than $4" } verify { total.isNotLessThan(MINIMUM_VALUE) }
        rule { "customer is required" } verify { customer !is Customer}
        rule { "informed customer was not found" } verify { customerRepository.findOne(customer!!.id) is Customer }
        rule { "seller is required" } verify { seller !is Seller }
        rule { "informed seller was not found" } verify { sellerRepository.findOne(seller!!.id) is Seller}
        rule { "seller is not active" } verify { !sellerRepository.findOne(seller!!.id)!!.active }
        rule { "coupon was not found" } verify { coupon != null && couponRepository.findOne(coupon!!.id) is Coupon }
    }

    val `for update order`: Validation<Order> = Validation {
        //...
    }
}

fun main(args: Array<String>) {
    val order = Order(
                total = BigDecimal.TEN,
                customer = Customer("1"),
                seller = Seller("2", true),
                coupon = Coupon("1"))

    val constraints = OrderValidationMyProposalKotlin()
    val validate: List<String> = order.validate(constraints.`for new order`)

    println(validate)
}