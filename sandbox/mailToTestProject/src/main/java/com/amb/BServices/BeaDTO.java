package com.amb.BServices;

public class BeaDTO {
    private int id;
    private String forename;
    private String surname;
    private boolean isPrincessBeatrice;
    private String arrivalTime;

    public BeaDTO(
            int id,
            String forename,
            String surname,
            boolean isPrincessBeatrice,
            String arrivalTime
    ) {
        this.setId(id);
        this.setForename(forename);
        this.setSurname(surname);
        this.setPrincessBeatrice(isPrincessBeatrice);
        this.setArrivalTime(arrivalTime);
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

    public boolean isPrincessBeatrice() {
        return isPrincessBeatrice;
    }

    public void setPrincessBeatrice(boolean princessBeatrice) {
        isPrincessBeatrice = princessBeatrice;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
