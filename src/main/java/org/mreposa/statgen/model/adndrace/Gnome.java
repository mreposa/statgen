package org.mreposa.statgen.model.adndrace;

public class Gnome extends PlayerCharacterRace {
    public Gnome() { super(); }

    @Override
    public int[] getUpdates() {
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[0] = 6;
        minimums[2] = 7;
        minimums[5] = 8;
        return minimums;
    }
}
