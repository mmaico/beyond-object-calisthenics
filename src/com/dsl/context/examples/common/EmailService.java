package com.dsl.context.examples.common;

import com.dsl.context.infra.Customer;
import com.dsl.context.infra.Email;
import com.dsl.context.infra.EmailRepository;

import static com.dsl.context.infra.java.Attendant.attendant;

public class EmailService {


    private EmailRepository emailRepository;

    public EmailService() {
        this.emailRepository = new EmailRepository();
    }

    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    public Email send(Email email, Customer customer) {
        return attendant().send(email).to(customer);
    }

}
