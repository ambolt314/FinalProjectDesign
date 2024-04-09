package com.amb;

import java.io.IOException;

public class Service {

    public EmailDocument getEmailDocument(EmailType type) throws Exception {
        return new EmailDocument(type);
    }
}
