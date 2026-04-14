package com.example.dnd_ai_backend.domain.monster;

public class DcCheck {

    private final String ability;
    private final int value;
    private final String successType;

    public DcCheck(String ability, int value, String successType) {
        this.ability = ability;
        this.value = value;
        this.successType = successType;
    }

    public String ability() { return ability; }
    public int value() { return value; }
    public String successType() { return successType; }
}
