package com.amb.AServices;

import java.util.Arrays;
import java.util.List;

public class AService {

    public ADTO getAByID(int id) throws Exception {

        List<ADTO> repo = Arrays.asList(
                new ADTO(1, "A service", "fac-001A", "Have an A1 Day!"),
                new ADTO(2, "AAA", "A113", "H@ve an A! Day1"),
                new ADTO(3, "Service A", "abc-1A", "HavE an a1 dAy!")
        );

        return repo.stream().filter(adto -> adto.getId() == id).findFirst().orElseThrow(Exception::new);
    }
}
