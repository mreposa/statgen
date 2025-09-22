package org.mreposa.statgen.model.adndclass;

public class ThiefAcrobat extends PlayerCharacterClass {
    public ThiefAcrobat() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_STR] = PRIMARY_UPDATE_VALUE;
        updates[STAT_DEX] = SECONDARY_UPDATE_VALUE;
        updates[STAT_CHA] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_DEX] = 16;
        return minimums;
    }
}
