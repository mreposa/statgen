package org.mreposa.statgen.model.adndrace;

public class HalfElf extends PlayerCharacterRace {
    public HalfElf() { super(); }

    @Override
    public int[] getUpdates() {
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[2] = 4;
        minimums[4] = 6;
        minimums[5] = 6;
        return minimums;
    }
}
