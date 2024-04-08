package com.amb;

import sun.net.www.protocol.mailto.MailToURLConnection;

import java.io.IOException;
import java.net.*;

public class EmailGenerator {

    private static final Service service = new Service();

    public EmailGenerator() {
    }

    public static void generateMailTo() throws IOException {
        EmailDocument document = service.getEmailDocument();

        String EMAIL_GEN_URL = "mailto:" + document.to;
        URL url = new URL(EMAIL_GEN_URL);

        MailToURLConnection connection = new MailToURLConnection(url);

    }
}