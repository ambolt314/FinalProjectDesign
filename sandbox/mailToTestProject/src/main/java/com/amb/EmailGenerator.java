package com.amb;

import sun.net.www.protocol.mailto.MailToURLConnection;

import java.awt.*;
import java.io.IOException;
import java.net.*;

public class EmailGenerator {

    private static final Service service = new Service();

    public EmailGenerator() {
    }

    public static void generateMailTo() throws IOException, URISyntaxException {

        EmailDocument document = service.getEmailDocument(EmailType.C);

        String uriStr = String.format("mailto:%s?subject=%s&body=%s",
                document.to,
                uriEncode(document.subject),
                uriEncode(document.body));

        URI uri = new URI(uriStr);
        Desktop.getDesktop().mail(uri);

    }

    public static String uriEncode(String s) {
        return s.replace(" ", "%20")
                .replace("\n", "%0A")
                .replace("\r", "%0D");
    }
}
