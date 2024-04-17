package com.example.emailGeneratorAPI;

import com.example.emailGeneratorAPI.BasicPersonDetails.BasicPersonDetailsDTO;
import com.example.emailGeneratorAPI.BasicPersonDetails.BasicPersonDetailsService;
import com.example.emailGeneratorAPI.templates.MailTemplate;
import com.example.emailGeneratorAPI.templates.TemplateNameConstants;
import com.example.emailGeneratorAPI.templates.TemplateUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class EmailGenerator {

    private final MailTemplate mailTemplate = new MailTemplate();

    /**
     * This method generates a new email document
     * @param type - the type of email to be generated (ACCOMMODATION_CONFIRMATION, BOOKING_REMINDER, CAB_CONFIRMATION)
     * @param visitorID - the id of the visitor who is the email data subject
     * @return - a new email document, with the required data
     * @throws IOException
     * @throws TemplateException
     */
    public EmailDocument generate(EmailType type, int visitorID) throws IOException, TemplateException {

        EmailDocument document = new EmailDocument(type);
        BasicPersonDetailsDTO details = (new BasicPersonDetailsService()).getPersonById(visitorID);
        Template template;
        HashMap<String, Object> dataModel = new HashMap<>();

        switch (type) {
            case ACCOMMODATION_CONFIRMATION: {
                template = mailTemplate.getTemplate(TemplateNameConstants.ACCOMMODATION_CONFIRMATION_TEMPLATE_NAME);
                dataModel.put("name", details.getDisplayName());
                // list other data model additions here
                break;
            }
            case BOOKING_REMINDER:{
                document.setSubject("Booking reminder");
                template = mailTemplate.getTemplate(TemplateNameConstants.BOOKING_REMINDER_TEMPLATE_NAME);
                break;
            }
            case CAB_CONFIRMATION: {
                document.setSubject("Cab confirmation");
                template = mailTemplate.getTemplate(TemplateNameConstants.CAB_CONFIRMATION_TEMPLATE_NAME);
                break;
            }
            default: throw new IllegalStateException("Unexpected value: " + document.getType()); //TODO: work out kind of exception I want here
        }

        String body = TemplateUtils.buildStringFromTemplate(template, dataModel);

        document.setBody(body);

        return document;
    }

    /**
     * This method renders the email document as a new email window
     * @param document - the email document to be rendered
     * @throws URISyntaxException
     * @throws IOException
     */
    void render(EmailDocument document) throws URISyntaxException, IOException {
        String mailTo = String.format("mailto:%s?subject=%s&body=%s&cc=%s",
                sanitise(document.getTo()),
                sanitise(document.getSubject()),
                sanitise(document.getBody()),
                sanitise(document.getCc())
        );

        URI uri = new URI(mailTo);

        Desktop.getDesktop().mail(uri);

    }

    /**
     * This method is required for security reasons
     * @param s - the string to be sanitised
     * @return - a sanitised version of the string
     */
    private String sanitise(String s) {
        return s.replace(" ", "%20")
                .replace("\n", "%0A")
                .replace("\r", "%0D");
    }
}
