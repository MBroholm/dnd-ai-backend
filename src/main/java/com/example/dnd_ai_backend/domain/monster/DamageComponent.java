package com.example.dnd_ai_backend.domain.monster;

import com.example.dnd_ai_backend.domain.dice.DiceRoll;

public class DamageComponent {

    private final String type;
    private final DiceRoll dice;

    public DamageComponent(String type, DiceRoll dice) {
        this.type = type;
        this.dice = dice;
    }

    public String type() { return type; }
    public DiceRoll dice() { return dice; }
}
