package org.mreposa.statgen.model.adndclass;

public class Druid extends PlayerCharacterClass {
    public Druid() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_WIS] = PRIMARY_UPDATE_VALUE;
        updates[STAT_CHA] = SECONDARY_UPDATE_VALUE;
        updates[STAT_CON] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_WIS] = 12;
        minimums[STAT_CHA] = 15;
        return minimums;
    }
}
