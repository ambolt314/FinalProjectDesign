package com.amb.AServices;

import java.util.Dictionary;

public class ADTO {
    private int id;
    private String name;
    private String facilityReference;
    private String breakingBadReference;

    public ADTO(
            int id,
            String name,
            String facilityReference,
            String breakingBadReference
    ) {
        this.setId(id);
        this.setName(name);
        this.setFacilityReference(facilityReference);
        this.setBreakingBadReference(breakingBadReference);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacilityReference() {
        return facilityReference;
    }

    public void setFacilityReference(String facilityReference) {
        this.facilityReference = facilityReference;
    }

    public String getBreakingBadReference() {
        return breakingBadReference;
    }

    public void setBreakingBadReference(String breakingBadReference) {
        this.breakingBadReference = breakingBadReference;
    }
}
