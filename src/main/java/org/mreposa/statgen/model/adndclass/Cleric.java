package org.mreposa.statgen.model.adndclass;

public class Cleric extends PlayerCharacterClass {
    public Cleric() { super(); }

    @Override
    public int[] getUpdates() {
        updates[3] = PRIMARY_UPDATE_VALUE;
        updates[5] = SECONDARY_UPDATE_VALUE;
        updates[0] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[3] = 9;
        return minimums;
    }
}
