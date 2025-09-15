package org.mreposa.statgen.model.adndclass;

public class Normal extends PlayerCharacterClass {
    public Normal() {
        super();
    }

    @Override
    public int[] getUpdates() {
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 8;
        minimums[2] = 8;
        minimums[3] = 8;
        minimums[4] = 8;
        minimums[5] = 8;
        minimums[6] = 8;
        return minimums;
    }
}
