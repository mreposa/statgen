package org.mreposa.statgen.model.adndclass;

public class Barbarian extends PlayerCharacterClass {
    public Barbarian() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_STR] = PRIMARY_UPDATE_VALUE;
        updates[STAT_CON] = SECONDARY_UPDATE_VALUE;
        updates[STAT_DEX] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_DEX] = 14;
        minimums[STAT_CON] = 15;
        return minimums;
    }
}
