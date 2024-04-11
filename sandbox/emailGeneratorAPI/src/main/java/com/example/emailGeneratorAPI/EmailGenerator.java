package com.example.emailGeneratorAPI;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class EmailGenerator {

    public static void generateMailTo(EmailDocument document) throws IOException, URISyntaxException {

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
