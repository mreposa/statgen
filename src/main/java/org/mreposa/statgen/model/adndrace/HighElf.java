package org.mreposa.statgen.model.adndrace;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;

public class HighElf extends PlayerCharacterRace {
    public HighElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_DEX] = 1;
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
