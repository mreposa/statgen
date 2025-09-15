package org.mreposa.statgen.model.adndclass;

public class CavalierPaladin extends PlayerCharacterClass {
    public CavalierPaladin() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[6] = PRIMARY_UPDATE_VALUE;
        updates[0] = SECONDARY_UPDATE_VALUE;
        updates[4] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 15;
        minimums[2] = 10;
        minimums[3] = 13;
        minimums[4] = 15;
        minimums[5] = 15;
        minimums[6] = 17;
        return minimums;
    }
}
