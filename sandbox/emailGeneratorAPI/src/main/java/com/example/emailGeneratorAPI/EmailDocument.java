package com.example.emailGeneratorAPI;

public class EmailDocument {
    private String to;
    private String toName;
    private String cc;
    private String subject;
    private String body;

    public EmailDocument(
            String to,
            String toName,
            String cc,
            String subject,
            String body
    ) {
        this.setTo(to);
        this.setToName(toName);
        this.setCc(cc);
        this.setSubject(subject);
        this.setBody(body);
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
}