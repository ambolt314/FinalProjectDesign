package com.amb;

import java.awt.*;
import java.net.URI;

public class EmailGenerator {

    private static final Service service = new Service();

    public EmailGenerator() {
    }

    public static void generateMailTo() throws Exception {

        EmailDocument document = service.getEmailDocument(EmailType.A);

        String mailTo = String.format("mailto:%s?subject=%s&body=%s&cc=%s",
                sanitise(document.getTo()),
                sanitise(document.getSubject()),
                sanitise(document.getBody()),
                sanitise(document.getCc())
        );

        URI uri = new URI(mailTo);
        Desktop.getDesktop().mail(uri);

    }

    private static String sanitise(String s) {
        return s.replace(" ", "%20")
                .replace("\n", "%0A")
                .replace("\r", "%0D");
    }
}
