package com.amb;

import java.awt.*;
import java.io.IOException;
import java.net.*;

public class EmailGenerator {

    private static final Service service = new Service();

    public EmailGenerator() {
    }

    public static void generateMailTo() throws IOException, URISyntaxException {

        EmailDocument document = service.getEmailDocument(EmailType.C);

        String mailTo = String.format("mailto:%s?subject=%s&body=%s",
                sanitise(document.getTo()),
                sanitise(document.getSubject()),
                sanitise(document.getBody()));

        URI uri = new URI(mailTo);
        Desktop.getDesktop().mail(uri);

    }

    private static String sanitise(String s) {
        return s.replace(" ", "%20")
                .replace("\n", "%0A")
                .replace("\r", "%0D");
    }
}
