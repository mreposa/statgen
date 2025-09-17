package org.mreposa.statgen.model.adndrace;

public class WildElf extends PlayerCharacterRace {
    public WildElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = 2;
        updates[6] = -2;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 8;
        minimums[2] = 6;
        minimums[4] = 7;
        minimums[5] = 8;
        minimums[6] = 6;
        return minimums;
    }
}
