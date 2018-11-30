package com.robertx22.unique_items.chest;

import java.util.Arrays;
import java.util.List;

import com.robertx22.database.stat_mods.flat.MajorDodgeFlat;
import com.robertx22.database.stat_mods.flat.resources.HealthFlat;
import com.robertx22.database.stat_mods.percent.DodgePercent;
import com.robertx22.database.stat_mods.percent.much_less.CrippleLifeOnHitPercent;
import com.robertx22.stats.StatMod;
import com.robertx22.unique_items.bases.BaseUniqueChest;

public class ChestDodge extends BaseUniqueChest {

    public ChestDodge() {

    }

    @Override
    public int Tier() {
	return 14;

    }

    @Override
    public String name() {
	return "Thief's Chestplate";
    }

    @Override
    public String GUID() {
	return "chestdodge0";
    }

    @Override
    public List<StatMod> uniqueStats() {
	return Arrays.asList(new HealthFlat(), new MajorDodgeFlat(), new DodgePercent(), new CrippleLifeOnHitPercent());
    }

    @Override
    public String description() {
	return "Come on, hit me!";
    }

}