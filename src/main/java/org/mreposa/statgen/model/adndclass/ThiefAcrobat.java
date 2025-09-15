package org.mreposa.statgen.model.adndclass;

public class ThiefAcrobat extends PlayerCharacterClass {
    public ThiefAcrobat() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[4] = PRIMARY_UPDATE_VALUE;
        updates[0] = SECONDARY_UPDATE_VALUE;
        updates[6] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 15;
        minimums[4] = 16;
        return minimums;
    }
}
