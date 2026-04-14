package com.example.dnd_ai_backend.domain.monster;

import java.util.List;
import java.util.Map;

public class Monster {

    private final String index;
    private final String name;
    private final String size;
    private final String type;
    private final String alignment;

    private final int maxHp;
    private int currentHp;

    private final int armorClass;

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    private final Map<String, Integer> speeds; // walk=40, fly=80, etc.

    private final List<MonsterAction> actions;
    private final List<MonsterAction> legendaryActions;

    public Monster(
            String index,
            String name,
            String size,
            String type,
            String alignment,
            int maxHp,
            int armorClass,
            int strength,
            int dexterity,
            int constitution,
            int intelligence,
            int wisdom,
            int charisma,
            Map<String, Integer> speeds,
            List<MonsterAction> actions,
            List<MonsterAction> legendaryActions) {
        this.index = index;
        this.name = name;
        this.size = size;
        this.type = type;
        this.alignment = alignment;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.armorClass = armorClass;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.speeds = speeds;
        this.actions = actions;
        this.legendaryActions = legendaryActions;
    }

    // --- Combat Logic ---

    public void takeDamage(int amount) {
        currentHp = Math.max(0, currentHp - amount);
    }

    public void heal(int amount) {
        currentHp = Math.min(maxHp, currentHp + amount);
    }

    public boolean isDead() {
        return currentHp <= 0;
    }

    // --- Getters ---

    public String index() {
        return index;
    }

    public String name() {
        return name;
    }

    public String size() {
        return size;
    }

    public String type() {
        return type;
    }

    public String alignment() {
        return alignment;
    }

    public int maxHp() {
        return maxHp;
    }

    public int currentHp() {
        return currentHp;
    }

    public int armorClass() {
        return armorClass;
    }

    public int strength() {
        return strength;
    }

    public int dexterity() {
        return dexterity;
    }

    public int constitution() {
        return constitution;
    }

    public int intelligence() {
        return intelligence;
    }

    public int wisdom() {
        return wisdom;
    }

    public int charisma() {
        return charisma;
    }

    public Map<String, Integer> speeds() {
        return speeds;
    }

    public List<MonsterAction> actions() {
        return actions;
    }

    public List<MonsterAction> legendaryActions() {
        return legendaryActions;
    }
}