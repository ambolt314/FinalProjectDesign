package com.example.emailGeneratorAPI;

import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class EmailDocumentController {

    EmailGenerator emailGenerator = new EmailGenerator();

    @GetMapping("/email-contents")
    public EmailDocument createRawEmail(
            @RequestParam(value = "visitorID", defaultValue = "1") int visitorID
    ) throws TemplateException, IOException, URISyntaxException {
        return emailGenerator.generate(EmailType.ACCOMMODATION_CONFIRMATION, visitorID);
    }

    @GetMapping("/email/{emailType}")
    public void createEmail(
            @PathVariable("emailType") String emailType,
            @RequestParam(value = "visitorID", defaultValue = "1") int visitorID
    ) throws IOException, URISyntaxException, TemplateException {
        EmailDocument document = emailGenerator.generate(EmailType.valueOfType(emailType), visitorID);
        emailGenerator.render(document);
    }
}
