package com.example.emailGeneratorAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class EmailDocumentController {

    EmailDocumentService service = new EmailDocumentService();

    @GetMapping("/raw-email")
    public EmailDocument createRawEmail(@RequestParam(value = "visitorID", defaultValue = "1") int visitorID) {
        return service.getEmailDocument(visitorID);
    }

    @GetMapping("/email")
    public void createEmail(@RequestParam(value = "visitorID", defaultValue = "1") int visitorID) throws IOException, URISyntaxException {
        EmailDocument emailDocument = service.getEmailDocument(visitorID);

        EmailGenerator.generateMailTo(emailDocument);
    }
}
