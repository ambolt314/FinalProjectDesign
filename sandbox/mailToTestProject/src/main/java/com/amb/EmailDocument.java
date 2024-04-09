package com.amb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmailDocument {

    String to;
    String toName;

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

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



    public EmailDocument(EmailType type) throws IOException {
        switch (type) {
            case A: {
                this.setTo("person-A@email.com");
                this.setToName("Person A");
                this.setCc("user-office@email.com");
                this.setSubject("Email type A");
                this.setBody(getEmailBodyFromFile("C:\\Programming\\FinalProjectDesign\\sandbox\\mailToTestProject\\src\\main\\java\\com\\amb\\A-body.txt"));
                break;
            }
            case B: {
                this.setTo("B-someone@email.com");
                this.setToName("Be Someone");
                this.setCc("user-office@email.com");
                this.setSubject("Email type B");
                this.setBody(getEmailBodyFromFile("C:\\Programming\\FinalProjectDesign\\sandbox\\mailToTestProject\\src\\main\\java\\com\\amb\\B-body.txt"));
                break;
            }
            case C: {
                this.setTo("C-that-person@email.com");
                this.setToName("C That-Person");
                this.setCc("user-office@email.com");
                this.setSubject("Email type C");
                this.setBody(getEmailBodyFromFile("C:\\Programming\\FinalProjectDesign\\sandbox\\mailToTestProject\\src\\main\\java\\com\\amb\\C-body.txt"));
                break;
            }
        }
    }

    public String getEmailBodyFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        byte[] bytes = Files.readAllBytes(path);
        String data = new String(bytes);

        return String.format(data, this.toName);

    }
}
