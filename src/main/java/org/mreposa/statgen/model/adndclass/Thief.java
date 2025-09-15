package org.mreposa.statgen.model.adndclass;

public class Thief extends PlayerCharacterClass {
    public Thief() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[4] = PRIMARY_UPDATE_VALUE;
        updates[2] = SECONDARY_UPDATE_VALUE;
        updates[6] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[4] = 9;
        return minimums;
    }
}
