package com.amb.BServices;

import java.util.Arrays;
import java.util.List;

public class BeaService {
    public BeaDTO getBeaById(int id) throws Exception {
        List<BeaDTO> repo = Arrays.asList(
                new BeaDTO(1, "Beanie-Meanie-Fo-Feanie", "Anderson", false, "21:00:00"),
                new BeaDTO(2, "Beatrice", "York", true, "13:45:00")
        );

        return repo.stream().filter(beadto -> beadto.getId() == id).findFirst().orElseThrow(Exception::new);

    }
}
