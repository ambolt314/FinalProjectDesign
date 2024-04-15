package com.example.emailGeneratorAPI.BasicPersonDetails;

public class BasicPersonDetailsService {

    public BasicPersonDetailsDTO getPersonById(int id) {
        BasicPersonDetailsDTO details = new BasicPersonDetailsDTO();

        switch (id) {
            case 1 -> {
                details.setDisplayName("Fake Fakerson");
                details.setEmail("fake@email.com");
                break;
            }
            case 2 -> {
                details.setDisplayName("John Johnson");
                details.setEmail("jonjon@email.com");
                break;
            }
            default -> {
                details.setDisplayName("Fake Fakerson");
                details.setEmail("fake@email.com");
            }
        }

        return details;
    }
}
