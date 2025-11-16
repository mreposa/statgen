package org.mreposa.statgen.model.adnd.race;

import org.mreposa.statgen.model.adnd.playerclass.PlayerCharacterClass;

public class Halfling extends PlayerCharacterRace {
    public Halfling() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_STR] = -1;
        updates[PlayerCharacterClass.STAT_DEX] = 1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_STR] = 6;
        minimums[PlayerCharacterClass.STAT_INT] = 6;
        minimums[PlayerCharacterClass.STAT_DEX] = 8;
        minimums[PlayerCharacterClass.STAT_CON] = 10;
        return minimums;
    }
}
