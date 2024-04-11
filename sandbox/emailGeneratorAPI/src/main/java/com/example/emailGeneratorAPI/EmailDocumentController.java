package com.example.emailGeneratorAPI;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class EmailDocumentController {

    EmailDocumentService service = new EmailDocumentService();

    @GetMapping("/raw")
    public EmailDocument createRawEmail(
            @RequestParam(value = "visitorID", defaultValue = "1") int visitorID
    ) {
        return service.getEmailDocument(EmailType.ACCOMMODATION_CONFIRMATION, visitorID);
        //return service.getEmailDocument(EmailType.valueOfType(emailType), visitorID);
    }

    @GetMapping("/email/{emailType}")
    public void createEmail(
            @PathVariable("emailType") String emailType,
            @RequestParam(value = "visitorID", defaultValue = "1") int visitorID
    ) throws IOException, URISyntaxException {
        EmailDocument emailDocument = service.getEmailDocument(EmailType.valueOfType(emailType), visitorID);
        EmailGenerator.generateMailTo(emailDocument);
    }
}
