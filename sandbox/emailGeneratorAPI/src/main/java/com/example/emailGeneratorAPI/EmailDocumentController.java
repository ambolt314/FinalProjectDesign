package com.example.emailGeneratorAPI;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailDocumentController {

    @GetMapping("/raw-email")
    public EmailDocument getRawEmail(@RequestParam(value = "visitorID", defaultValue = "1") int visitorID) {
        return new EmailDocument(
                "fake@email.com",
                "Fake Fakerson",
                "useroffice@email.com",
                "Your request has been approved",
                "Dear Fake, your request has been approved. Bisous, User Office"
        );
    }
}
