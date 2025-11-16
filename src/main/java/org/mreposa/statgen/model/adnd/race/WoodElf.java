package org.mreposa.statgen.model.adnd.race;

import org.mreposa.statgen.model.adnd.playerclass.PlayerCharacterClass;

public class WoodElf extends PlayerCharacterRace {
    public WoodElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_STR] = 1;
        updates[PlayerCharacterClass.STAT_INT] = -1;
        updates[PlayerCharacterClass.STAT_COM] = 1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_STR] = 8;
        minimums[PlayerCharacterClass.STAT_INT] = 6;
        minimums[PlayerCharacterClass.STAT_DEX] = 7;
        minimums[PlayerCharacterClass.STAT_CON] = 6;
        minimums[PlayerCharacterClass.STAT_CHA] = 8;
        return minimums;
    }
}
