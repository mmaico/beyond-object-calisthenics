package com.dsl.context.infra.java;

import com.dsl.context.infra.Customer;
import com.dsl.context.infra.Email;
import com.dsl.context.infra.EmailRepository;

public class Attendant {

    private EmailRepository emailRepository;

    private String id;

    public Attendant() {
        emailRepository = new EmailRepository();
    }

    public static Attendant attendant() {
        return new Attendant();
    }


    public ToCustomer send(Email email) {
        return customer -> {
            email.setFrom(this);
            email.setTo(customer);
            return emailRepository.save(email);
        };
    }

    @FunctionalInterface
    public interface ToCustomer {
        Email to(Customer customer);
    }
}
