package org.mreposa.statgen.model.adndclass;

public class Barbarian extends PlayerCharacterClass {
    public Barbarian() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[0] = PRIMARY_UPDATE_VALUE;
        updates[5] = SECONDARY_UPDATE_VALUE;
        updates[4] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 15;
        minimums[4] = 14;
        minimums[5] = 15;
        return minimums;
    }
}
