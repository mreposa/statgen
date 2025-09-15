package org.mreposa.statgen.model.adndclass;

public class Assassin extends PlayerCharacterClass {
    public Assassin() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[4] = PRIMARY_UPDATE_VALUE;
        updates[0] = SECONDARY_UPDATE_VALUE;
        updates[2] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 12;
        minimums[2] = 11;
        minimums[4] = 12;
        return minimums;
    }
}
