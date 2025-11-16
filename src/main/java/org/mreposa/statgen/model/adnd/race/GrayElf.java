package org.mreposa.statgen.model.adnd.race;

import org.mreposa.statgen.model.adnd.playerclass.PlayerCharacterClass;

public class GrayElf extends PlayerCharacterRace {
    public GrayElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_INT] = 1;
        updates[PlayerCharacterClass.STAT_CON] = -1;
        updates[PlayerCharacterClass.STAT_COM] = 2;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_INT] = 8;
        minimums[PlayerCharacterClass.STAT_DEX] = 7;
        minimums[PlayerCharacterClass.STAT_CON] = 6;
        minimums[PlayerCharacterClass.STAT_CHA] = 8;
        return minimums;
    }
}
