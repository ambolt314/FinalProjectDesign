package com.amb.BServices;

import java.util.Arrays;
import java.util.List;

public class BeeService {

    public BeeDTO getBeeById(int id) throws Exception {
        List<BeeDTO> repo = Arrays.asList(
                new BeeDTO(1, "Barry", 5, "Queen Bee"),
                new BeeDTO(2, "Bertha", 3111900, "Rimskaya-Korsakova")
        );

        return repo.stream().filter(beedto -> beedto.getId() == id).findFirst().orElseThrow(Exception::new);

    }
}
