package com.amb;

public class EmailDocument {

    String to;
    String cc;
    String subject;
    String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



    public EmailDocument(EmailType type) {
        switch (type) {
            case A: {
                this.setTo("person-A@email.com");
                this.setCc("user-office@email.com");
                this.setSubject("Email type A");
                this.setBody("A test email");
                break;
            }
            case B: {
                this.setTo("B-someone@email.com");
                this.setCc("user-office@email.com");
                this.setSubject("Email type B");
                this.setBody("B test email");
                break;
            }
            case C: {
                this.setTo("C-that-person@email.com");
                this.setCc("user-office@email.com");
                this.setSubject("Email type C");
                this.setBody("C test email");
                break;
            }
        }
    }
}
