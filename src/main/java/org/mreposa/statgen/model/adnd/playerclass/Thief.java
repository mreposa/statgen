package org.mreposa.statgen.model.adnd.playerclass;

public class Thief extends PlayerCharacterClass {
    public Thief() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_DEX] = PRIMARY_UPDATE_VALUE;
        updates[STAT_INT] = SECONDARY_UPDATE_VALUE;
        updates[STAT_CHA] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_DEX] = 9;
        return minimums;
    }
}
