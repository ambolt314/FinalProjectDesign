package com.example.emailGeneratorAPI;

import javax.ws.rs.BadRequestException;

public enum EmailType {
    ACCOMMODATION_CONFIRMATION("accommodation-confirmation"),
    BOOKING_REMINDER("booking-reminder"),
    CAB_CONFIRMATION("cab-confirmation");

    public final String type;

    EmailType(String type) {
        this.type = type;
    }

    public static EmailType valueOfType(String type) {
        for (EmailType e: values()) {
            if(e.type.equals(type.toLowerCase())) {
                return e;
            }
        }

        throw new BadRequestException("Invalid email type " + type);
    }
}
