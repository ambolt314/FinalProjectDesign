package com.example.emailGeneratorAPI;

public class EmailDocument {
    private String to;
    private String toName;
    private String cc;
    private String subject;
    private String body;
    private EmailType type;

    public EmailDocument(EmailType type) {
        this.setTo("");
        this.setToName("");
        this.setCc("");
        this.setSubject("");
        this.setBody("");
        this.setType(type);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
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

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        this.type = type;
    }
}