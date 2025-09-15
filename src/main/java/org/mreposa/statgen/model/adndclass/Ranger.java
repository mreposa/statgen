package org.mreposa.statgen.model.adndclass;

public class Ranger extends PlayerCharacterClass {
    public Ranger() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[5] = PRIMARY_UPDATE_VALUE;
        updates[4] = SECONDARY_UPDATE_VALUE;
        updates[0] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 13;
        minimums[2] = 13;
        minimums[3] = 14;
        minimums[5] = 14;
        return minimums;
    }
}
