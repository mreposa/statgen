package org.mreposa.statgen.model.adndclass;

public class Fighter extends PlayerCharacterClass {
    public Fighter() {
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
        minimums[0] = 9;
        minimums[5] = 7;
        return minimums;
    }
}
