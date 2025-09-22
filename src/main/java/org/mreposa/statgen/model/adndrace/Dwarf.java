package org.mreposa.statgen.model.adndrace;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;

public class Dwarf extends PlayerCharacterRace {
    public Dwarf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_CON] = 1;
        updates[PlayerCharacterClass.STAT_CHA] = -1;
        updates[PlayerCharacterClass.STAT_COM] = -1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_STR] = 8;
        minimums[PlayerCharacterClass.STAT_CON] = 12;
        return minimums;
    }
}
