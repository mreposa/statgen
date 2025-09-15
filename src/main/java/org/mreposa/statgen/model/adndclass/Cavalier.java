package org.mreposa.statgen.model.adndclass;

public class Cavalier extends PlayerCharacterClass {
    public Cavalier() {
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
        minimums[2] = 10;
        minimums[3] = 10;
        minimums[4] = 15;
        minimums[5] = 15;
        return minimums;
    }
}
