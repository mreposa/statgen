package org.mreposa.statgen.model.adndclass;

public class MagicUser extends PlayerCharacterClass {
    public MagicUser() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[2] = PRIMARY_UPDATE_VALUE;
        updates[4] = SECONDARY_UPDATE_VALUE;
        updates[5] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[2] = 9;
        minimums[4] = 6;
        return minimums;
    }
}
