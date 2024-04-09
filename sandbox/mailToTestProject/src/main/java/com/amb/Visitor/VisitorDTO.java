package com.amb.Visitor;

public class VisitorDTO {
    private int id;
    private String forename;
    private String surname;
    private String email;

    public VisitorDTO(
            int id,
            String forename,
            String surname,
            String email
    ) {
        this.setId(id);
        this.setForename(forename);
        this.setSurname(surname);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
