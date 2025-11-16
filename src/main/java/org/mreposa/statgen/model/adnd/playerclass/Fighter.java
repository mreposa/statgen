package org.mreposa.statgen.model.adnd.playerclass;

public class Fighter extends PlayerCharacterClass {
    public Fighter() {
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
        minimums[STAT_STR] = 9;
        minimums[STAT_CON] = 7;
        return minimums;
    }
}
