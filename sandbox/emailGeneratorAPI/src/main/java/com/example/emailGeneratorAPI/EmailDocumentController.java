package com.example.emailGeneratorAPI;

import freemarker.template.TemplateException;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class EmailDocumentController {

    EmailGenerator emailGenerator = new EmailGenerator();

    @Path("/email-contents/{emailType}")
    public EmailDocument createRawEmail(
            @PathVariable("emailType") String emailType,
            @RequestParam(value = "visitorID", defaultValue = "1") int visitorID
    ) throws TemplateException, IOException {
        return emailGenerator.generate(EmailType.valueOfType(emailType), visitorID);
    }

    @Path("/email/{emailType}")
    public void createEmail(
            @PathVariable("emailType") String emailType,
            @RequestParam(value = "visitorID", defaultValue = "1") int visitorID
    ) throws IOException, URISyntaxException, TemplateException {
        EmailDocument document = emailGenerator.generate(EmailType.valueOfType("insurance-notification"), visitorID);
        emailGenerator.render(document);
    }
}
