package com.example.dnd_ai_backend.util;

import com.example.dnd_ai_backend.dto.spell.SpellDetailResponse;
import com.example.dnd_ai_backend.dto.common.DamageDto;
import com.example.dnd_ai_backend.dto.common.DcDto;
import com.example.dnd_ai_backend.dto.common.AreaOfEffectDto;

public class SpellFormatter {
    private SpellFormatter() {
        /* This utility class should not be instantiated */
    }

    public static String format(SpellDetailResponse spell) {

        String desc = spell.desc() != null ? String.join("\n", spell.desc()) : "None";
        String higherLevel = spell.higherLevel() != null ? String.join("\n", spell.higherLevel()) : "None";
        String components = spell.components() != null ? String.join(", ", spell.components()) : "None";

        String classes = spell.classes() != null
                ? spell.classes().stream().map(c -> c.name()).reduce((a, b) -> a + ", " + b).orElse("None")
                : "None";

        String subclasses = spell.subclasses() != null
                ? spell.subclasses().stream().map(c -> c.name()).reduce((a, b) -> a + ", " + b).orElse("None")
                : "None";

        String damageBlock = formatDamage(spell.damage());
        String dcBlock = formatDc(spell.dc());
        String aoeBlock = formatAreaOfEffect(spell.areaOfEffect());

        return """
                === Spell Overview ===
                Name: %s
                Level: %d
                School: %s

                === Casting Details ===
                Casting Time: %s
                Range: %s
                Duration: %s
                Ritual: %s
                Concentration: %s

                === Components ===
                Components: %s
                Material: %s

                === Mechanics ===
                Attack Type: %s
                Classes: %s
                Subclasses: %s

                %s
                %s
                %s

                === Description ===
                %s

                === Higher Level Casting ===
                %s
                """.formatted(
                spell.name(),
                spell.level(),
                spell.school().name(),

                spell.castingTime(),
                spell.range(),
                spell.duration(),
                spell.ritual(),
                spell.concentration(),

                components,
                spell.material() == null ? "None" : spell.material(),

                spell.attackType() == null ? "None" : spell.attackType(),
                classes,
                subclasses,

                damageBlock,
                dcBlock,
                aoeBlock,

                desc,
                higherLevel);
    }

    private static String formatDamage(DamageDto damage) {
        if (damage == null)
            return "=== Damage ===\nNone";

        String type = damage.damageType() != null ? damage.damageType().name() : "Unknown";
        String slotScaling = damage.damageAtSlotLevel() != null ? damage.damageAtSlotLevel().toString() : "None";
        String levelScaling = damage.damageAtCharacterLevel() != null ? damage.damageAtCharacterLevel().toString()
                : "None";

        return """
                === Damage ===
                - Type: %s
                - Damage at Slot Level: %s
                - Damage at Character Level: %s
                """.formatted(type, slotScaling, levelScaling);
    }

    private static String formatDc(DcDto dc) {
        if (dc == null)
            return "=== DC ===\nNone";

        return """
                === DC ===
                - Type: %s
                - Success: %s
                - Description: %s
                """.formatted(
                dc.dcType() != null ? dc.dcType().name() : "Unknown",
                dc.dcSuccess() == null ? "None" : dc.dcSuccess(),
                dc.desc() == null ? "None" : dc.desc());
    }

    private static String formatAreaOfEffect(AreaOfEffectDto aoe) {
        if (aoe == null)
            return "=== Area of Effect ===\nNone";

        return """
                === Area of Effect ===
                - Type: %s
                - Size: %d
                """.formatted(aoe.type(), aoe.size());
    }
}
