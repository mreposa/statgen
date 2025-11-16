package org.mreposa.statgen.model.adnd.playerclass;

public class CavalierPaladin extends PlayerCharacterClass {
    public CavalierPaladin() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_CHA] = PRIMARY_UPDATE_VALUE;
        updates[STAT_STR] = SECONDARY_UPDATE_VALUE;
        updates[STAT_DEX] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_INT] = 10;
        minimums[STAT_WIS] = 13;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 15;
        minimums[STAT_CHA] = 17;
        return minimums;
    }
}
