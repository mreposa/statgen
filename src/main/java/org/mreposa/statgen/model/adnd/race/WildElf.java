package org.mreposa.statgen.model.adnd.race;

import org.mreposa.statgen.model.adnd.playerclass.PlayerCharacterClass;

public class WildElf extends PlayerCharacterRace {
    public WildElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_STR] = 2;
        updates[PlayerCharacterClass.STAT_CHA] = -2;
        updates[PlayerCharacterClass.STAT_COM] = 1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_STR] = 8;
        minimums[PlayerCharacterClass.STAT_INT] = 6;
        minimums[PlayerCharacterClass.STAT_DEX] = 7;
        minimums[PlayerCharacterClass.STAT_CON] = 8;
        minimums[PlayerCharacterClass.STAT_CHA] = 6;
        return minimums;
    }
}
