package com.amb;

import java.awt.*;
import java.io.IOException;
import java.net.*;

public class EmailGenerator {

    private static final Service service = new Service();

    public EmailGenerator() {
    }

    public static void generateMailTo() throws IOException, URISyntaxException {

        EmailDocument document = service.getEmailDocument(EmailType.B);

        String uriStr = String.format("mailto:%s?subject=%s&body=%s",
                sanitise(document.to),
                sanitise(document.subject),
                sanitise(document.body));

        URI uri = new URI(uriStr);
        Desktop.getDesktop().mail(uri);

    }

    private static String sanitise(String s) {
        return s.replace(" ", "%20")
                .replace("\n", "%0A")
                .replace("\r", "%0D");
    }
}
