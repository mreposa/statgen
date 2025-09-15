package org.mreposa.statgen.model.adndclass;

public class Paladin extends PlayerCharacterClass {
    public Paladin() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[6] = PRIMARY_UPDATE_VALUE;
        updates[3] = SECONDARY_UPDATE_VALUE;
        updates[0] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 12;
        minimums[2] = 9;
        minimums[3] = 13;
        minimums[5] = 9;
        minimums[6] = 17;
        return minimums;
    }
}
