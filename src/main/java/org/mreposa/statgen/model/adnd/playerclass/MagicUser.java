package org.mreposa.statgen.model.adnd.playerclass;

public class MagicUser extends PlayerCharacterClass {
    public MagicUser() {
        super();
    }

    @Override
    public int[] getUpdates() {
        updates[STAT_INT] = PRIMARY_UPDATE_VALUE;
        updates[STAT_DEX] = SECONDARY_UPDATE_VALUE;
        updates[STAT_CON] = TERTIARY_UPDATE_VALUE;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_INT] = 9;
        minimums[STAT_DEX] = 6;
        return minimums;
    }
}
