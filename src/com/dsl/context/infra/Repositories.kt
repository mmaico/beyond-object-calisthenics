package com.dsl.context.infra

class EmailRepository {

    companion object {
        val customers = hashMapOf(
                "1" to Email("1"),
                "2" to Email("2")
        )
    }

    fun save(email: Email): Email? {
        customers.put("3", email)
        return email
    }

}



