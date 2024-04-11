package com.example.emailGeneratorAPI;

import javax.ws.rs.NotFoundException;

public class EmailDocumentService {



    public EmailDocument getEmailDocument(EmailType emailType, int visitorID) {

        EmailDocument document = new EmailDocument();

        document.setTo("fake@email.com");
        document.setToName("Fake Fakerson");
        document.setCc("useroffice@email.com");

        switch (emailType) {
            case ACCOMMODATION_CONFIRMATION -> {
                document.setSubject("Accommodation confirmation");
                document.setBody("Dear person, your accommodation request has been successful.");
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
