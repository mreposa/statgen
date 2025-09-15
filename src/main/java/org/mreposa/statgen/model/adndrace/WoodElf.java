package org.mreposa.statgen.model.adndrace;

public class WoodElf extends PlayerCharacterRace {
    public WoodElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = 1;
        updates[2] = -1;
        return updates;
    }
}
