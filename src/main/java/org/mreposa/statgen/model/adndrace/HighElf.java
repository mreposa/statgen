package org.mreposa.statgen.model.adndrace;

public class HighElf extends PlayerCharacterRace {
    public HighElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[4] = 1;
        updates[5] = -1;
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
