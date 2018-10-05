package com.dsl.context.infra

import com.dsl.context.infra.java.Attendant
import java.util.*

data class Email(val id: String? = UUID.randomUUID().toString(),
                 var from: Attendant? = null,
                 var to: Customer? = null

)


data class Customer(var id: String)


data class Attendant(val id: String? = UUID.randomUUID().toString()) {


    infix fun send(email: Email) = object: SendTo {
        override fun to(customer: Customer) {
            TODO("Call repository to save the email")
        }
    }

   interface SendTo {
       fun to(customer: Customer)
   }
}

fun main(args: Array<String>) {
    val email = Email()
    val customer = Customer("")

    com.dsl.context.infra.Attendant().send(email).to(customer)


}