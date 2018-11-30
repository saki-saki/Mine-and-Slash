package com.robertx22.database.stat_types.elementals.spell_to_attack;

import com.robertx22.database.stat_types.elementals.spell_damage.SpellWaterDamage;
import com.robertx22.stats.Stat;
import com.robertx22.uncommon.enumclasses.Elements;

public class WaterSpellToAttackDMG extends BaseSpellToBasicDamage {
    public static String GUID = "Water Spell to Attack DMG";

    public WaterSpellToAttackDMG() {

    }

    @Override
    public String Name() {
	return GUID;
    }

    @Override
    public Elements Element() {
	return Elements.Water;
    }

    @Override
    public Stat StatThatGiveDamage() {
	return new SpellWaterDamage();
    }
}