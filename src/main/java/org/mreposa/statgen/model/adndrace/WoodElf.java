package org.mreposa.statgen.model.adndrace;

public class WoodElf extends PlayerCharacterRace {
    public WoodElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = 1;
        updates[2] = -1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[2] = 8;
        minimums[4] = 7;
        minimums[5] = 6;
        minimums[6] = 8;
        return minimums;
    }
}
