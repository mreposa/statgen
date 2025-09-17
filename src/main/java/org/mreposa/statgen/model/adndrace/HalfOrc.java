package org.mreposa.statgen.model.adndrace;

public class HalfOrc extends PlayerCharacterRace {
    public HalfOrc() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = 1;
        updates[5] = 1;
        updates[6] = -2;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 6;
        minimums[5] = 13;
        return minimums;
    }
}
