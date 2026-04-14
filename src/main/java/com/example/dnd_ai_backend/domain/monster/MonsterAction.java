package com.example.dnd_ai_backend.domain.monster;

import java.util.List;

public class MonsterAction {

    private final String name;
    private final String description;
    private final Integer attackBonus;
    private final List<DamageComponent> damage;
    private final DcCheck dc;

    public MonsterAction(
            String name,
            String description,
            Integer attackBonus,
            List<DamageComponent> damage,
            DcCheck dc
    ) {
        this.name = name;
        this.description = description;
        this.attackBonus = attackBonus;
        this.damage = damage;
        this.dc = dc;
    }

    public String name() { return name; }
    public String description() { return description; }
    public Integer attackBonus() { return attackBonus; }
    public List<DamageComponent> damage() { return damage; }
    public DcCheck dc() { return dc; }
}