package org.mreposa.statgen.model.adnd.playerclass;

public class Paladin extends PlayerCharacterClass {
    public Paladin() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_CHA] = PRIMARY_UPDATE_VALUE;
        updates[STAT_WIS] = SECONDARY_UPDATE_VALUE;
        updates[STAT_STR] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 12;
        minimums[STAT_INT] = 9;
        minimums[STAT_WIS] = 13;
        minimums[STAT_CON] = 9;
        minimums[STAT_CHA] = 17;
        return minimums;
    }
}
