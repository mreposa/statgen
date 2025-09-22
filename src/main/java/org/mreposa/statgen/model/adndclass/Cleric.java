package org.mreposa.statgen.model.adndclass;

public class Cleric extends PlayerCharacterClass {
    public Cleric() { super(); }

    @Override
    public int[] getUpdates() {
        updates[STAT_WIS] = PRIMARY_UPDATE_VALUE;
        updates[STAT_CON] = SECONDARY_UPDATE_VALUE;
        updates[STAT_STR] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_WIS] = 9;
        return minimums;
    }
}
