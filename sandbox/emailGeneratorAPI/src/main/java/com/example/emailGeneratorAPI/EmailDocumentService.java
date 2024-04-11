package com.example.emailGeneratorAPI;

import javax.ws.rs.NotFoundException;

public class EmailDocumentService {

    public EmailDocument getEmailDocument(int visitorID) {

        String TO = "fake@email.com";
        String TO_NAME = "Fake Fakerson";
        String CC = "useroffice@email.com";
        String SUBJECT;
        String BODY;

        switch (visitorID) {
            case 1: {
                SUBJECT = "Approval request for Type 1";
                BODY = "Dear Fake, Your request has been approved. Kind regards, UO";
                return new EmailDocument(TO, TO_NAME, CC, SUBJECT, BODY);
            }
            case 2: {
                SUBJECT = "Confirmation of Two service";
                BODY = "Dear Mr Fakeson, Your request has been approved. Kind regards, UO";
                return new EmailDocument(TO, TO_NAME, CC, SUBJECT, BODY);
            }
            default: throw new NotFoundException("Visitor ID " + visitorID);
        }


    }
}
