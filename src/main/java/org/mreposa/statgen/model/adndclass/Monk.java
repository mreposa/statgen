package org.mreposa.statgen.model.adndclass;

public class Monk extends PlayerCharacterClass {
    public Monk() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[4] = PRIMARY_UPDATE_VALUE;
        updates[3] = SECONDARY_UPDATE_VALUE;
        updates[5] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 15;
        minimums[3] = 15;
        minimums[4] = 15;
        minimums[5] = 11;
        return minimums;
    }
}
