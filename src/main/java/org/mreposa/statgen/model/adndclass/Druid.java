package org.mreposa.statgen.model.adndclass;

public class Druid extends PlayerCharacterClass {
    public Druid() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[3] = PRIMARY_UPDATE_VALUE;
        updates[6] = SECONDARY_UPDATE_VALUE;
        updates[5] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[3] = 12;
        minimums[6] = 15;
        return minimums;
    }
}
