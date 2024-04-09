package com.amb.Visitor;

public class VisitorService {
    public VisitorDTO getCaller() {
        return new VisitorDTO(1, "Andrew", "Bolt", "andrew.bolt@stfc.ac.uk");
    }
}
