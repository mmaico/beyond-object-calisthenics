package com.dsl.context.examples.common

import com.dsl.context.infra.Attendant
import com.dsl.context.infra.Customer
import com.dsl.context.infra.Email



class EmailServiceKotlin {


    fun send(email: Email, customer: Customer) {
        Attendant() send email to customer
    }
}