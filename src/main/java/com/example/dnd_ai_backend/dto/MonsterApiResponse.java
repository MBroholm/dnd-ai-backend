package com.example.dnd_ai_backend.dto;

import java.util.List;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MonsterApiResponse(
        String index,
        String name,
        String size,
        String type,
        String alignment,
        List<ArmorClass> armorClass,
        int hitPoints,
        String hitDice,
        String hitPointsRoll,
        Speed speed,
        int strength,
        int dexterity,
        int constitution,
        int intelligence,
        int wisdom,
        int charisma,
        List<Proficiency> proficiencies,
        List<String> damageVulnerabilities,
        List<String> damageResistances,
        List<String> damageImmunities,
        List<ConditionImmunity> conditionImmunities,
        Senses senses,
        String languages,
        double challengeRating,
        int proficiencyBonus,
        int xp,
        List<SpecialAbility> specialAbilities,
        List<ActionApi> actions,
        List<LegendaryAction> legendaryActions,
        String image,
        String url,
        String updatedAt,
        List<Object> forms,
        List<Object> reactions
) {}

