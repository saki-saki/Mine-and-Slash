package com.robertx22.mine_and_slash.database.item_modifications;

import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryEntry;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistryType;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import com.robertx22.mine_and_slash.uncommon.interfaces.IWeighted;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.DataItemType;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.ICommonDataItem;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import net.minecraft.util.text.ITextComponent;

public abstract class BaseItemModification implements IWeighted, IRarity, ISlashRegistryEntry<BaseItemModification> {

    @Override
    public Rarity getRarity() {
        return Rarities.Items.get(getRarityRank());
    }

    @Override
    public int Weight() {
        return getRarity().Weight();
    }

    @Override
    public int getRarityRank() {
        return IRarity.Uncommon;
    }

    @Override
    public SlashRegistryType getSlashRegistryType() {
        return SlashRegistryType.ITEM_MODIFICATION;
    }

    @Override
    public int Tier() {
        return 0;
    }

    public boolean canModify(ICommonDataItem data) {
        return isRightDataType(data) && canModifyPRIVATE(data);
    }

    public abstract DataItemType getDataType();

    public boolean isRightDataType(ICommonDataItem data) {
        return getDataType().isType(data);
    }

    public abstract ITextComponent locName();

    public abstract boolean canModifyPRIVATE(ICommonDataItem data);

    public abstract void modify(ICommonDataItem data);
}