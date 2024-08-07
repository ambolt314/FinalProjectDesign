package com.amb;

import com.amb.AServices.ADTO;
import com.amb.AServices.AService;
import com.amb.BServices.BeaDTO;
import com.amb.BServices.BeaService;
import com.amb.BServices.BeeDTO;
import com.amb.BServices.BeeService;
import com.amb.Visitor.VisitorDTO;
import com.amb.Visitor.VisitorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmailDocument {

    private String to;
    private String toName;
    private String cc;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
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


    public EmailDocument(EmailType type) throws Exception {

        // dynamically retrieve caller information
        VisitorService visitorService = new VisitorService();
        VisitorDTO visitorDTO = visitorService.getCaller();

        this.setTo(visitorDTO.getEmail());
        this.setToName(visitorDTO.getForename() + " " + visitorDTO.getSurname());
        this.setCc("user-office@email.com");

        switch (type) {
            case A: {
                this.setSubject("Email type A");

                AService aService = new AService();
                ADTO adto = aService.getAByID(1); //this would be based on the caller details
                String bodyTemplate = getEmailBodyFromFile("C:\\Programming\\FinalProjectDesign\\sandbox\\mailToTestProject\\src\\main\\java\\com\\amb\\AServices\\A-body-template.txt");
                String body = String.format(
                        bodyTemplate,
                        this.getToName(),
                        adto.getName(),
                        adto.getId(),
                        adto.getFacilityReference(),
                        adto.getBreakingBadReference()
                );
                this.setBody(body);
                break;
            }
            case B: {
                this.setSubject("Email type B");

                BeaService beaService = new BeaService();
                BeaDTO beaDTO = beaService.getBeaById(1);

                BeeService beeService = new BeeService();
                BeeDTO beeDTO = beeService.getBeeById(2);

                String bodyTemplate = getEmailBodyFromFile("C:\\Programming\\FinalProjectDesign\\sandbox\\mailToTestProject\\src\\main\\java\\com\\amb\\BServices\\B-body-template.txt");
                String body = String.format(
                        bodyTemplate,
                        beaDTO.getForename(),
                        beaDTO.getSurname(),
                        beaDTO.getIsPrincessBeatrice() ? "Royal Highness' " : "",
                        beaDTO.getIsPrincessBeatrice() ? "Royal Highness' " : "",
                        beaDTO.getArrivalTime(),
                        beaDTO.getIsPrincessBeatrice() ? "r Royal Highness" : "",
                        beeDTO.getName(),
                        beeDTO.getFavouriteNumber(),
                        beeDTO.getQueen()
                );

                this.setBody(body);
                break;
            }
            case C: {
                this.setSubject("Email type C");
                this.setBody(getEmailBodyFromFile("C:\\Programming\\FinalProjectDesign\\sandbox\\mailToTestProject\\src\\main\\java\\com\\amb\\CServices\\C-body-template.txt"));
                break;
            }
        }
    }

    private String getEmailBodyFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes);

    }
}
