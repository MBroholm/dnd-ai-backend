package com.example.dnd_ai_backend.domain.dice;

import java.util.concurrent.ThreadLocalRandom;

public class DiceService {
    public int roll(DiceRoll roll) {
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        int total = 0;
        for (int i = 0; i < roll.dice(); i++) {
            total += rng.nextInt(1, roll.sides() + 1);
        }
        return total + roll.modifier();
    }
}

