package org.mreposa.statgen.model.adndclass;

public class Ranger extends PlayerCharacterClass {
    public Ranger() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_CON] = PRIMARY_UPDATE_VALUE;
        updates[STAT_WIS] = SECONDARY_UPDATE_VALUE;
        updates[STAT_STR] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 13;
        minimums[STAT_INT] = 13;
        minimums[STAT_WIS] = 14;
        minimums[STAT_CON] = 14;
        return minimums;
    }
}
