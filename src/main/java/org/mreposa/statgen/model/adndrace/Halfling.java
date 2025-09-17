package org.mreposa.statgen.model.adndrace;

public class Halfling extends PlayerCharacterRace {
    public Halfling() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = -1;
        updates[4] = 1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 6;
        minimums[2] = 6;
        minimums[4] = 8;
        minimums[5] = 10;
        return minimums;
    }
}
