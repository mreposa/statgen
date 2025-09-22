package org.mreposa.statgen.model.adndclass;

public class Monk extends PlayerCharacterClass {
    public Monk() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_DEX] = PRIMARY_UPDATE_VALUE;
        updates[STAT_WIS] = SECONDARY_UPDATE_VALUE;
        updates[STAT_CON] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_WIS] = 15;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 11;
        return minimums;
    }
}
