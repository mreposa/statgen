package org.mreposa.statgen.model.adndrace;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;

public class HalfOrc extends PlayerCharacterRace {
    public HalfOrc() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_STR] = 1;
        updates[PlayerCharacterClass.STAT_CON] = 1;
        updates[PlayerCharacterClass.STAT_CHA] = -2;
        updates[PlayerCharacterClass.STAT_COM] = -3;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_STR] = 6;
        minimums[PlayerCharacterClass.STAT_CON] = 13;
        return minimums;
    }
}
