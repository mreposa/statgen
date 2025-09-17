package org.mreposa.statgen.model.adndrace;

public class Dwarf extends PlayerCharacterRace {
    public Dwarf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[5] = 1;
        updates[6] = -1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 8;
        minimums[5] = 12;
        return minimums;
    }
}
