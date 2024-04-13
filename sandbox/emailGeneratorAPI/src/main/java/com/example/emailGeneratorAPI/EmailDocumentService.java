package com.example.emailGeneratorAPI;

import com.example.emailGeneratorAPI.templates.MailTemplate;
import com.example.emailGeneratorAPI.templates.TemplateNameConstants;
import com.example.emailGeneratorAPI.templates.TemplateUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class EmailDocumentService {

    MailTemplate mailTemplate = new MailTemplate();

    public EmailDocument getEmailDocument(EmailType emailType, int visitorID) throws IOException, TemplateException {

        EmailDocument document = new EmailDocument();
        BasicPersonDetailsDTO details = new BasicPersonDetailsDTO();

        document.setTo(details.getEmail());
        document.setToName(details.getDisplayName());
        document.setCc("user-office@email.com");

        switch (emailType) {
            case ACCOMMODATION_CONFIRMATION -> {
                document.setSubject("Accommodation confirmation");

                //Set up email body
                String body;

                Template template = mailTemplate.getTemplate(TemplateNameConstants.ACCOMMODATION_CONFIRMATION_TEMPLATE_NAME);
                HashMap<String, Object> dataModel = new HashMap<>();

                dataModel.put("name", "World");

                body = TemplateUtils.buildStringFromTemplate(template, dataModel);



                document.setBody(body);
            }
            case BOOKING_REMINDER -> {
                document.setSubject("Booking reminder");
                document.setBody("Dear person, this is a reminder to make a booking.");
            }
            case CAB_CONFIRMATION -> {
                document.setSubject("Cab confirmation");
                document.setBody("Dear person, your cab has been booked successfully.");
            }
        }

        switch (visitorID) {
            case 1 -> {
                document.setTo("fake-1@email.com");
                document.setToName("Fake Fakerson");
                return document;
            }
            case 2 -> {
                document.setTo("fake-2@email.com");
                document.setToName("John Johnson");
                return document;
            }
            default -> throw new NotFoundException("Visitor ID " + visitorID);
        }

    }
}
