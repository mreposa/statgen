package org.mreposa.statgen.model.adndclass;

public class Assassin extends PlayerCharacterClass {
    public Assassin() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_DEX] = PRIMARY_UPDATE_VALUE;
        updates[STAT_STR] = SECONDARY_UPDATE_VALUE;
        updates[STAT_INT] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 12;
        minimums[STAT_INT] = 11;
        minimums[STAT_DEX] = 12;
        return minimums;
    }
}
