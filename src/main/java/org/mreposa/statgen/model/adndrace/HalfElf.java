package org.mreposa.statgen.model.adndrace;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;

public class HalfElf extends PlayerCharacterRace {
    public HalfElf() { super(); }

    @Override
    public int[] getUpdates() {
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_INT] = 4;
        minimums[PlayerCharacterClass.STAT_DEX] = 6;
        minimums[PlayerCharacterClass.STAT_CON] = 6;
        updates[PlayerCharacterClass.STAT_COM] = 1;
        return minimums;
    }
}
