package org.mreposa.statgen.model.adnd.playerclass;

public class Cavalier extends PlayerCharacterClass {
    public Cavalier() {
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
        minimums[STAT_INT] = 10;
        minimums[STAT_WIS] = 10;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 15;
        return minimums;
    }
}
