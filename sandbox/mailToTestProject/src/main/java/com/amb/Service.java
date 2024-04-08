package com.amb;

public class Service {

    public EmailDocument getEmailDocument(EmailType type) {
        return new EmailDocument(type);
    }
}
