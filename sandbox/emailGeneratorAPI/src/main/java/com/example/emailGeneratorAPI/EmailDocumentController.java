package com.example.emailGeneratorAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailDocumentController {

    EmailDocumentService service = new EmailDocumentService();

    @GetMapping("/raw-email")
    public EmailDocument getRawEmail(@RequestParam(value = "visitorID", defaultValue = "1") int visitorID) {
        return service.getEmailDocument(visitorID);
    }
}
