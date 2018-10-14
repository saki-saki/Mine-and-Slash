package com.robertx22.database.stats.mods.flat;

import com.robertx22.database.stats.types.Damage;
import com.robertx22.enums.StatTypes;
import com.robertx22.interfaces.IWeighted;
import com.robertx22.stats.Stat;
import com.robertx22.stats.StatMod;

public class DamageFlat extends StatMod {

	public DamageFlat() {
	}

	@Override
	public String GUID() {
		return "DamageFlat";
	}

	@Override
	public int Min() {
		return 1;
	}

	@Override
	public int Max() {
		return 5;
	}

	@Override
	public StatTypes Type() {
		return StatTypes.Flat;
	}

	@Override
	public Stat GetBaseStat() {
		return new Damage();
	}

	@Override
	public int Weight() {
		return IWeighted.NormalWeight;
	}

}