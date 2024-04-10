package com.example.emailGeneratorAPI;

@RestController
public class EmailDocumentController {

    @GetMapping("/raw-email")
    public EmailDocument getRawEmail(@RequestParam() int visitorID) {

    }
}
