package com.amb;

public class Service {

    public EmailDocument getEmailDocument() {
        return new EmailDocument(EmailType.A);
    }
}
